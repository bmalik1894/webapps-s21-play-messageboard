package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef
import play.api.libs.json.Json
import edu.trinity.videoquizreact.shared.{Line, Point}

class DrawActor(out: ActorRef, manager:ActorRef) extends Actor {
    import DrawActor._
    import DrawManager._
    
    def receive = {
        case s:String => {
            if (s.count(_ == ',') == 5) {
                val nums = s.split(",")
                val (pointa, pointb) = (Point(nums(0).toDouble, nums(1).toDouble), Point(nums(2).toDouble, nums(3).toDouble)) 
                manager ! DrawManager.NewLine(Line(pointa, pointb, nums(4), nums(5)))
            } else if (s == "I'm new!") {
                manager ! DrawManager.NewGuy(self)
            }
        }
        case DrawManager.UpdateVect(s) => out ! s
        case m => println("Unhandled message in draw actor: " + m)
    }
}


object DrawActor {
    def props(out: ActorRef, manager:ActorRef) = Props(new DrawActor(out, manager))

}