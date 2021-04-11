package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef
import play.api.libs.json.Json

class MessageActor(out: ActorRef, manager:ActorRef) extends Actor {
    import MessageActor._
    import MessageManager._


    def receive = {
        case s:String =>
            if (s.length >= 20 && s.substring(0, 19) == "New user connected:") manager ! MessageManager.NewUser(self, s.substring(19))
            else if (s == "GET MESSAGES.") manager ! MessageManager.InitSendMessages(self)
            else if (s == "User disconnected.") manager ! MessageManager.RemoveUser(self)
            else if (s.length >= 11 && s.substring(0, 11) == "NewMessage`") manager ! MessageManager.NewMessage(s.substring(11))
            else if (s == "Get users.") manager ! MessageManager.SendUsersTo(self)
            else manager ! MessageManager.NewMessage(s)
        case UpdateMessages(user:MessageManager.User) => updateAll(user)
        case GetUsers(users) => sendOutUsers(users)
        case GettingMessages(user) => updateAll(user) 
        case m => println("Unhandled message in chat actor: " + m)
    }

    def updateAll(user:MessageManager.User) = {
        var data = ""
        
        var j = 0
        if (user.messages.length != 0) {
        for (j <- 0 until user.messages.length) {
            data += user.messages{j}.to + "`" 
            data += user.messages(j).from + "`"
            data += user.messages(j).body + "`"
            data += user.messages(j).time + "\n"
            }
            data = data.substring(0, data.length - 1)
            out ! data
        }
    }

    def sendOutUsers(users:Array[MessageManager.User]) = {
        var data = "CurrUserlist:"
        for (user <- users) {
            data += user.name + ","
        }
        data = data.substring(0, data.length - 1)
        out ! data
    }
}

object MessageActor {
    def props(out: ActorRef, manager:ActorRef) = Props(new MessageActor(out, manager))
    case class GetUsers(users:Array[MessageManager.User])
    case class UpdateMessages(user:MessageManager.User)
    case class GettingMessages(user:MessageManager.User)
}