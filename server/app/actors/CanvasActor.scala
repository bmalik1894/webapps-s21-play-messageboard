package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef
import play.api.libs.json.Json

class CanvasActor(out: ActorRef, manager:ActorRef) extends Actor {
    import CanvasActor._
    import CanvasManager._


    def receive = {
        case s:String => 
            if (s == "New user connected.") manager ! CanvasManager.NewUser(self) 
            else if (s == "User disconnected.") manager ! CanvasManager.RemoveUser(self)
            else manager ! CanvasManager.UserActivity(self, s)
        case SendToClient(users) => updateAll(users)
        case m => println("Unhandled message in chat actor: " + m)
    }

    def updateAll(userlist:Array[CanvasManager.User]) = {
        var i = 0
        var barearray:Array[String] = Array()
        var data = ""
        for (i <- 0 until userlist.length) {
            data += userlist(i).name + ","
            data += userlist(i).color + ","
            data += userlist(i).x.toString() + ","
            data += userlist(i).y.toString()
            data += ";"
        }
        data = data.substring(0, data.length - 1)
        println(data)
        out ! data
    }
}

object CanvasActor {
    def props(out: ActorRef, manager:ActorRef) = Props(new CanvasActor(out, manager))
    case class SendToClient(users:Array[CanvasManager.User])
}