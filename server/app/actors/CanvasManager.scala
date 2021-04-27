package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef
import scala.util.Random

class CanvasManager extends Actor {
    import CanvasManager._
    private var characterNames = Array("Badger", "Armadillo", "Dragonfly", "Camel", "Flamingo", "Tortise", "Ostritch", "Python", "Rat")
    private var colors = Array("blue", "red", "orange", "black", "brown", "gray", "purple", "pink", "green")
    var users:Array[User] = Array()
    private val random = new Random

    
    def receive = {
        case s:String => print("Got " + s + " in Manager")
        case NewUser(user) => userInit(user)
        case RemoveUser(user) => removeUser(user)
        case UserActivity(user, direction) => updateLocation(user, direction)
        case m => println("Unhandled message in chat manager: " + m)
    }

    def userInit(ref:ActorRef) = {
        val name = characterNames(random.nextInt(characterNames.length))
        characterNames = characterNames.filterNot(x => x == name)
        val color = colors(random.nextInt(colors.length))
        colors = colors.filterNot(x => x == color)

        println("\nInitializing new user: " + name)
        val xinit = random.nextInt(200)
        val yinit = random.nextInt(200)
        users = users ++ Array(User(ref, name, color, xinit, yinit))

        for (i <- 0 until users.length) {
            val ref = users(i).reference
            ref ! CanvasActor.SendToClient(users)
        }
    }

    def updateLocation(user:ActorRef, direction:String) = {
        var index = 0
        if (!users.isEmpty) {
            for (i <- 0 until users.length) {
                if (users(i).reference == user) {
                    index = i
                }
            }

            if (direction == "left") {
                users(index) = new User(users(index).reference, users(index).name, users(index).color, users(index).x - 5, users(index).y)
            } else if (direction == "right") {
                users(index) = new User(users(index).reference, users(index).name, users(index).color, users(index).x + 5, users(index).y)
            } else if (direction == "up") {
                users(index) = new User(users(index).reference, users(index).name, users(index).color, users(index).x, users(index).y - 5)
            } else if (direction == "down") {
                users(index) = new User(users(index).reference, users(index).name, users(index).color, users(index).x, users(index).y + 5)
            }

            for (i <- 0 until users.length) {
                val actor = users(i).reference
                actor ! CanvasActor.SendToClient(users)
            }
        }
    }

    def removeUser(user:ActorRef) = {
        for (i <- 0 until users.length) {
            if (users(i).reference == user) {
                println(users(i).name + " disconnected.")
                users = users.filterNot(x => x == users(i))
            }
        }
    }

}

object CanvasManager {
    case class NewUser(user: ActorRef)
    case class RemoveUser(user: ActorRef)
    case class User(reference:ActorRef, name:String, color:String, x:Double, y:Double)
    case class UserActivity(user:ActorRef, direction:String)

}