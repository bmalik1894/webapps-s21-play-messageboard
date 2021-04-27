package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.data._
import play.api.libs.json
import play.api.libs.json._
import models._
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.ExecutionContext
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future

@Singleton
class Messageboarddb @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents)(implicit ec:ExecutionContext) 
  extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] { 

    private val model = new DatabaseModel(db)
    

    implicit val userDataReads = Json.reads[UserData]
    implicit val userSendReads = Json.reads[UserSend]
    implicit val sendMessageReads = Json.reads[SendMessage]
    implicit val messageItemWrites = Json.writes[MessageItem]
    
    def mainload = Action { implicit request =>
        Ok(views.html.messagedb())
    }

    def withJsonBody[A](f: A => Future[Result])(implicit request: Request[AnyContent], reads: Reads[A]):Future[Result] = {
    request.body.asJson.map { body =>
      Json.fromJson[A](body) match {
        case JsSuccess(a, path) => f(a)
        case e @ JsError(_) => Future.successful(Redirect(routes.Messageboarddb.mainload()))
        }
      }.getOrElse(Future.successful(Redirect(routes.Messageboarddb.mainload())))
    }

    def withSessionUsername(f: String => Future[Result])(implicit request: Request[AnyContent]): Future[Result] = {
      request.session.get("username").map(f)
      .getOrElse(Future.successful(Ok(Json.toJson(Seq.empty[String]))))
    }

    def withSessionUserID(f:Int => Future[Result])(implicit request: Request[AnyContent]): Future[Result] = {
      request.session.get("userid").map(userid => f(userid.toInt)).getOrElse(Future.successful(Ok(Json.toJson(Seq.empty[String]))))
    }

    def validate = Action.async { implicit request =>
      withJsonBody[UserData] { ud =>
      model.validateUser(ud.username, ud.password).map { ouserId =>
        ouserId match {
          case Some(userid) => Ok(Json.toJson(true))
              .withSession("username" -> ud.username, "userid" -> userid.toString, "csrfToken" -> play.filters.csrf.CSRF.getToken.map(_.value).getOrElse(""))
          case None => Ok(Json.toJson(false))
          }
        }
      }
    }

    def createUser = Action.async { implicit request =>
    withJsonBody[UserData] { ud => model.createUser(ud.username, ud.password).map { ouserId =>   
      ouserId match {
        case Some(userid) =>
          Ok(Json.toJson(true))
            .withSession("username" -> ud.username, "userid" -> userid.toString, "csrfToken" -> play.filters.csrf.CSRF.getToken.map(_.value).getOrElse(""))
        case None =>
          Ok(Json.toJson(false))
        }
      } 
    }
  }

    def sendMessage = Action.async { implicit request =>
      withSessionUsername { username =>
        withJsonBody[SendMessage] { messageInfo =>
        model.sendMessage(username, messageInfo.toUser, messageInfo.body).map(bool => Ok(Json.toJson(bool)))
        }
      }
    }

    def messageList = Action.async { implicit request =>
      withSessionUsername { username =>
        model.getMessages(username).map(messsages => Ok(Json.toJson(messsages)))
      }
    }

    def getUsers = Action.async { implicit request =>
      model.listUsers().map(result => Ok(Json.toJson(result)))
    }

    def logout = Action { implicit request =>
    Ok(Json.toJson(true)).withSession(request.session - "username")
  }
}