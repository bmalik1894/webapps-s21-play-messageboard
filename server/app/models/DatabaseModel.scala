package models

import collection.mutable.Map
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import scala.util.Random

class DatabaseModel(db:Database)(implicit ec: ExecutionContext) {
    val rand = new Random
    private var colors = Array("blue", "red", "orange", "black", "brown", "gray", "purple", "pink", "green")


    def getIdFromUser(username:String): Option[Int] = {
        val mach = db.run(Users.filter(userRow => userRow.username === username).result)
        mach.map(userRows => userRows.headOption.flatMap {
            userRow => Some(userRow.id)
        } )
        None
    }

    def getUserFromId(userid:Int): Option[String] = {
        val mach = db.run(Users.filter(userRow => userRow.id === userid).result)
        mach.map(userRows => userRows.headOption.flatMap {
            userRow => Some(userRow.username)
        } )
        None
    }

    def validateUser(username: String, password:String): Future[Option[Int]] = {
        val matches = db.run(Users.filter(userRow => userRow.username === username && userRow.password === password).result)
        matches.map(userRows => userRows.headOption.flatMap {
            userRows => if (BCrypt.checkpw(password, userRows.password)) Some(userRows.id) else None 
        })
    }

    def createUser(username: String, password: String): Future[Option[Int]] = {
        val matches = db.run(Users.filter(userRow => userRow.username === username).result)
        matches.flatMap { userRows =>
        if (userRows.isEmpty) {
            
            db.run(Users += UsersRow(-1, username, colors(rand.nextInt(colors.length - 1)), BCrypt.hashpw(password, BCrypt.gensalt())))
            .flatMap { addCount => 
                if (addCount > 0) db.run(Users.filter(userRow => userRow.username === username).result)
                .map(_.headOption.map(_.id))
            else Future.successful(None)
          }
      } else Future.successful(None)
    }
  }

    def listUsers(): Future[Seq[String]] = {
        db.run(
            (for {
            user <- Users
            } yield {
                user.username
            }).result
        )
    }

    def sendMessage(userid:Int, target:String, message:String): Future[Boolean] = {
        val datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now())
        var targetid = getIdFromUser(target).getOrElse(-1)

        if (targetid != -1) {
            db.run(Messages += MessagesRow(-1, targetid, userid, message, datetime)).map(addCount => addCount > 0)
        } 
        else Future.successful(false)
    }



    def getMessages(username:String):Future[Seq[MessageItem]] = {
        db.run(
            (for {
                user <- Users if user.username === username
                message <- Messages if message.touser === user.id
            } yield {
                message
            }).result
        ).map(messages => messages.map(message => MessageItem(message.messageId, getUserFromId(message.touser).getOrElse("Unkown"), getUserFromId(message.fromuser).getOrElse("Unkown"), message.body, message.timestamp)))
    }

    def removeMessage(messageid:Int): Future[Boolean] = {
        db.run(Messages.filter(_.messageId === messageid).delete).map(count => count > 0)
    }

    def publics:Seq[String] = ??? 
}