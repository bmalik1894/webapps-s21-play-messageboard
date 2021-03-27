import org.scalatestplus.play._
import models.ApplicationInMemoryModel
import models.ApplicationInMemoryModel.Message
import org.scalatestplus.play.PlaySpec
import controllers.Application
import play.api.test.Helpers
import play.api.test.FakeRequest
import play.api.test.Helpers._
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import org.scalatestplus.play.OneBrowserPerSuite
import org.scalatestplus.play.HtmlUnitFactory


class ApplicationInMemoryModelTest extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
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

    "Application" must {
        "login to page successfully" in {
      go to s"http://localhost:$port/login"
      pageTitle mustBe "Login"
      find(cssSelector("h3")).isEmpty mustBe false
      click on id("post-username")
      textField(id("post-username")).value = "web"
      click on id("post-pass")
      pwdField(id("post-pass")).value = "apps"
      submit()
      eventually {
        pageTitle mustBe "Messages"
        find(cssSelector("h2")).isEmpty mustBe false
        find(cssSelector("h2")).foreach(e => e.text mustBe "Messages")
        find(cssSelector("h3"))
        //(findAll(cssSelector("li")).toList).length() mustBe 1
            }
        }

        "login to page unsuccessfully" in {
            go to s"http://localhost:$port/login"
            pageTitle mustBe "Login"
            find(cssSelector("h3")).isEmpty mustBe false
            click on id("post-username")
            textField(id("post-username")).value = "web"
            click on id("post-pass")
            pwdField(id("post-pass")).value = "appz"
            submit()
            eventually {
            pageTitle mustBe "Login"
            }
        }

        "create new user successfully" in {
            go to s"http://localhost:$port/login"
            pageTitle mustBe "Login"
            find(cssSelector("h3")).isEmpty mustBe false
            click on id("create-username")
            textField(id("create-username")).value = "wobble"
            click on id("create-pass")
            pwdField(id("create-pass")).value = "nowobbling"
            submit()
            eventually {
            pageTitle mustBe "Messages"
            }
        }

        "create new user unsuccessfully" in {
            go to s"http://localhost:$port/login"
            pageTitle mustBe "Login"
            find(cssSelector("h3")).isEmpty mustBe false
            click on id("create-username")
            textField(id("create-username")).value = "web"
            click on id("create-pass")
            pwdField(id("create-pass")).value = "nowobbling"
            submit()
            eventually {
            pageTitle must not be "Messages"
            }
        }

    }
}
