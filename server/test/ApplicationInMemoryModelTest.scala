import org.scalatestplus.play._
import models.ApplicationInMemoryModel
import models.ApplicationInMemoryModel.Message

class ApplicationInMemoryModelTest extends PlaySpec {
    "ApplicationInMemoryModel" must {
        "do valid login for default user" in {
            ApplicationInMemoryModel.validateUser("user", "pass") mustBe (true)
        }
        
        "reject bad user" in {
            ApplicationInMemoryModel.validateUser("user1", "pass") mustBe (false)
        }

        "reject bad password" in {
            ApplicationInMemoryModel.validateUser("user", "pass123") mustBe (false)
        }

        "reject bad user and password" in {
            ApplicationInMemoryModel.validateUser("user1", "pass123") mustBe (false)
        }

        "create new user with no tasks" in {
            ApplicationInMemoryModel.createUser("Mike", "password") mustBe (true)
            ApplicationInMemoryModel.getMessages("Mike") mustBe(Nil)
        }

        "reject create existing user" in {
            ApplicationInMemoryModel.createUser("user", "pass") mustBe (false)
        }

        "get correct mssages" in {
            ApplicationInMemoryModel.getMessages("web") mustBe (List(Message("mlewis", "Ok google.", "2002-09-04 06:29")))
        }

        "add new message for existing user" in {
            ApplicationInMemoryModel.sendMessage("mlewis", "web", "testing")
            ApplicationInMemoryModel.getMessages("web").head.body mustBe ("testing")
        }
        
        "remove message for existing user" in {
            ApplicationInMemoryModel.removeMessage("web", ApplicationInMemoryModel.getMessages("web").indexOf(Message("mlewis", "Ok google.", "2002-09-04 06:29")))
            ApplicationInMemoryModel.getMessages("web") must not contain (Message("mlewis", "Ok google.", "2002-09-04 06:29"))
        }

        
    }
}