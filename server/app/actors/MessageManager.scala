package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef
import scala.util.Random
import java.text.SimpleDateFormat
import java.util.{TimeZone, Date}

class MessageManager extends Actor {
    import MessageManager._
    private var colors = Array("blue", "red", "orange", "black", "brown", "purple", "pink", "green")
    var users:Array[User] = Array()
    private val random = new Random

    
    def receive = {
        case s:String => print("Got " + s + " in Manager")
        case NewUser(ref, name) => addUser(ref, name)
        case SendUsersTo(ref) => sendUsers(ref)
        case RemoveUser(user) => removeUser(user)
        case NewMessage(msg) => handleMessage(msg)
        case InitSendMessages(ref) => initMessages(ref) 
        case m => println("Unhandled message in chat manager: " + m)
    }

    def addUser(ref:ActorRef, name:String) = {
        val color = colors(random.nextInt(colors.length))
        val messages = Array[MessageManager.Message]()
        var index = 0
        var alreadyExists = false
        for (index <- 0 until userlist.length) {
            if (name == userlist(index).name) {
                userlist(index).reference = ref
                alreadyExists = true
                println(name + " connected to " + ref.toString())
            }
        }
        if (!alreadyExists) {
            userlist = userlist ++ Array(User(ref, name, color, messages))    
            println("Adding " + name + " to userlist")
        }
    }

    def handleMessage(rawMsg:String) = {
        // TURN RAW MESSAGE INTO MESSAGE DATATYPE
        val msgarray = rawMsg.split("`")
        val toUser = msgarray(1)
        val fromUser = msgarray(0)
        var messageinfo = ""
        var index = 2
        for (index <- 2 until msgarray.length) {
            messageinfo += msgarray(index)
        }
        
        val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        formatter.setTimeZone(TimeZone.getTimeZone("CDT"));
        val date = new Date(); //java.util.Date = Thu Oct 08 09:06:07 BST 2015
        val dateString = formatter.format(date); //String = 2015-10-08 08:06:07 UTC

        val msg = Message(messageinfo, toUser, fromUser, dateString)
        for (user <- userlist) {
            if (user.name == msg.to || user.name == msg.from || msg.to == "Everyone") {
                user.messages = user.messages ++ Array(msg)
                if (user.reference != null) user.reference ! MessageActor.UpdateMessages(user)
            }
        }

    }

    def sendUsers(ref:ActorRef) = {
        ref ! MessageActor.GetUsers(userlist)
    }

    def initMessages(ref:ActorRef) = {
        for (user <- userlist) {
            if (user.reference == ref) {
                ref ! MessageActor.UpdateMessages(user)
            }   
        }
    }

    def removeUser(user:ActorRef) = {
        for (i <- 0 until userlist.length) {
            if (userlist(i).reference == user) {
                println(userlist(i).name + " disconnected.")
                userlist(i).reference = null
            }
        }
    }
}

object MessageManager {
    // Datatypes
    case class Message(body:String, to:String, from:String, time:String)
    case class User(var reference:ActorRef, name:String, color:String, var messages:Array[Message])

    // Data
    var userlist = Array(User(null, "Everyone", "gray", Array(Message("Type a message", "Everyone", "Everyone", "0000-00-00 0:0:0"))))

    // Actions
    case class NewUser(user: ActorRef, name:String)
    case class RemoveUser(user: ActorRef)
    case class NewMessage(msg:String)
    case class SendUsersTo(ref:ActorRef)
    case class InitSendMessages(ref:ActorRef)

}