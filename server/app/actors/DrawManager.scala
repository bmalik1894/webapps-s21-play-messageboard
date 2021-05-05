package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef
import scala.util.Random
import java.text.SimpleDateFormat
import java.util.{TimeZone, Date}
import scala.collection.mutable.ArrayBuffer
import edu.trinity.videoquizreact.shared.{Line, Point}

class DrawManager extends Actor {
    import DrawManager._
    
    var vectors = Array[Line]()
    var users = Array[ActorRef]()


    def receive = {
        case NewGuy(p) => 
                users = users.prepended(p)
                updateVectors(null)
        case NewLine(line) => updateVectors(line)
        case m => println("Unhandled message in draw manager: " + m)
    }

    def updateVectors(line:Line) = {
        if (line != null) {
            vectors = vectors.appended(line)
        }

        var allvects = ""
        if (!vectors.isEmpty) {
            for (vector <- vectors) {
                allvects += vector.start.x.toString() + ","
                allvects += vector.start.y.toString() + ","
                allvects += vector.end.x.toString() + ","
                allvects += vector.end.y.toString() + ","
                allvects += vector.color + ","
                allvects += vector.size + ";"
            
            }
        allvects = allvects.substring(0, allvects.length - 1)
        }
        users.foreach(u => u ! UpdateVect(allvects))
    }

}

object DrawManager {
    case class NewLine(line:Line)
    case class NewGuy(person:ActorRef)
    case class UpdateVect(vects:String)
}
