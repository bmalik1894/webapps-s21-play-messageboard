package models

//import collection.concurrent.Map
import collection.mutable.Map
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime

object ApplicationInMemoryModel {

    case class Message(from:String, body:String, timestamp:String)
    //private val local = LocalDateTime.from(ZoneId.of("CDT"))
    private val users = Map[String, String]("mlewis" -> "prof", "web" -> "apps", "user" -> "pass")
    private val tasks = Map[String, Seq[String]]("user" -> List("A", "B", "C"), "web" -> List("app1", "app2"), "mlewis" -> List("Code", "Space"))
    private val messages = Map[String, Seq[Message]]("web" -> List(Message("mlewis", "Ok google.", "2002-09-04 06:29")), 
    "public" -> List(Message("mlewis", "lorem ipsum", "2002-09-04 06:38")))


    def validateUser(username: String, password:String): Boolean = {
        users.get(username).map(_ == password).getOrElse(false)
    }

    def createUser(username:String, password:String): Boolean = {
        if (users.contains(username)) false
        else {
            synchronized {
            users(username) = password
            true
            }
        }
    }

    def getTasks(username:String):Seq[String] = {
        tasks.get(username).getOrElse(Nil)
    }

    def addTask(username: String, task: String): Unit = {
        tasks(username) = task +: tasks.get(username).getOrElse(Nil)
    }

    def removeTask(username:String, index:Int): Boolean = {
        if (index < 0 || tasks.get(username).isEmpty || index >= tasks(username).length) false
        else {
            tasks(username) = tasks(username).patch(index, Nil, 1)
            true
        }
    }

    def listUsers() = users.keySet.toList

    def sendMessage(username:String, target:String, message:String) = {
        val datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now())
        synchronized {
            if (target == "all") {
                messages("public") = Message(username, message, datetime) +: messages.get("public").getOrElse(Nil)
            } else messages(target) = Message(username, message, datetime) +: messages.get(target).getOrElse(Nil) 
        }
    }

    def getMessages(username:String):Seq[Message] = messages.get(username).getOrElse(Nil)

    def removeMessage(username:String, index:Int): Boolean = {
        if (index < 0 || messages.get(username).isEmpty || index >= messages(username).length) false
        else  {
            synchronized {
                messages(username) = messages(username).patch(index, Nil, 1)
                true 
            }
        }
    }

    def publics:Seq[Message] = messages.get("public").getOrElse(Nil) 
}