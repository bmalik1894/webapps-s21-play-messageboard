package controllers

import javax.inject._

import edu.trinity.videoquizreact.shared.SharedMessages
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.awt.Desktop.Action
import java.lang.ProcessBuilder.Redirect
import models.ApplicationInMemoryModel

case class LoginData(username:String, password:String)

@Singleton
class Application @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {

  val loginForm = Form(mapping(
    "Username" -> text(3, 10),
    "Password" -> text(4)
  )(LoginData.apply)(LoginData.unapply))


  def login = Action { implicit request =>
    Ok(views.html.login(loginForm))
  }

  def validateLoginGet(username:String, password:String) = Action {
    Ok(s"$username logged in with $password")
  }

  def createUser = Action { implicit request => 
    val postvals = request.body.asFormUrlEncoded    
    postvals.map { args => 
      val username = args("newUsername").head
      val password = args("newPassword").head
      if (ApplicationInMemoryModel.createUser(username, password)) {
        Redirect(routes.Application.success()).withSession("username" -> username)
      } else {
        Redirect(routes.Application.login()).flashing("error" -> "User creation failed.")
      }
    }.getOrElse(Redirect(routes.Application.login()))
  }

  def createUserForm = Action { implicit request =>
        loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.login(formWithErrors)),
      ld =>
        if (ApplicationInMemoryModel.createUser(ld.username, ld.password)) {
          Redirect(routes.Application.success()).withSession("username" -> ld.username)
        } else {
          Redirect(routes.Application.login()).flashing("error" -> "User creation failed.")
        })
  }

  def validateLoginPost = Action { implicit request =>
    val postvals = request.body.asFormUrlEncoded
    postvals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (ApplicationInMemoryModel.validateUser(username, password)) {
        Redirect(routes.Application.success()).withSession("username" -> username)
      } else {
        Redirect(routes.Application.login()).flashing("error" -> "Invalid username/password combination.")
      }
    }.getOrElse(Redirect(routes.Application.login()))
  }

  def validateUserForm = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.login(formWithErrors)),
      ld => if (ApplicationInMemoryModel.validateUser(ld.username, ld.password)) {
        Redirect(routes.Application.success()).withSession("username" -> ld.username)
      } else {
        Redirect(routes.Application.login()).flashing("error" -> "Invalid username/password combination.")
      }
    )
  }

  def logout = Action {
    Redirect(routes.Application.login()).withNewSession//.flashing("Success" -> "Successfully Logged out.")
  }

  def success = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val tasks = ApplicationInMemoryModel.getTasks(username)
      val users = ApplicationInMemoryModel.listUsers()
      val msgs  = ApplicationInMemoryModel.getMessages(username)
      val pubs  = ApplicationInMemoryModel.publics
      Ok(views.html.success(tasks, msgs, pubs, users, username))
    }.getOrElse(Redirect(routes.Application.login()))
  }

  def addTask = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map { args =>
        val task = args("newTask").head
        ApplicationInMemoryModel.addTask(username, task);
        Redirect(routes.Application.success())
      }.getOrElse(Redirect(routes.Application.success()).flashing("error" -> "could not add task"))
    }.getOrElse(Redirect(routes.Application.login()))
  }

  def deleteTask = TODO

  def deleteMessage = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map { args =>
      val index = args("index").head.toInt
      ApplicationInMemoryModel.removeMessage(username, index)
      Redirect(routes.Application.success())
      }.getOrElse(Redirect(routes.Application.success()).flashing("error" -> "Could not delete message."))
    }.getOrElse(Redirect(routes.Application.login()))
  }

  def sendMessage = Action { implicit request =>
   val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      val users = ApplicationInMemoryModel.listUsers()
      postVals.map { args =>
        val target = args("userList").head
        val message = args("messageText").head
        ApplicationInMemoryModel.sendMessage(username, target, message);
        Redirect(routes.Application.success())
      }.getOrElse(Redirect(routes.Application.success()).flashing("error" -> "Could not send message. "))
    }.getOrElse(Redirect(routes.Application.login()))
  }

  def deletePrivateMessage() = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { args =>
      val message = "1"
      Redirect(routes.Application.success())
    }.getOrElse(Redirect(routes.Application.success()).flashing("error" -> "Could not Delete"))
  }

}
