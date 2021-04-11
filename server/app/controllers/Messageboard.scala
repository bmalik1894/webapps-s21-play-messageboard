package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.data._
import play.api.libs.json
import play.api.libs.json._
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.actor.Props
import actors.MessageActor
import actors.MessageManager
import models.ApplicationInMemoryModel

@Singleton
class Messageboard @Inject()(cc: MessagesControllerComponents)(implicit system: ActorSystem, mat:Materializer) extends MessagesAbstractController(cc) { 
    val manager = system.actorOf(Props[MessageManager], "MessageManager")
    case class UserData(username:String, password:String)
    implicit val userDataReads = Json.reads[UserData]


    def mainload = Action { implicit request =>
        Ok(views.html.successWebSock())
    }
    
    def socket = WebSocket.accept[String,String] { request =>
        ActorFlow.actorRef { out =>
            MessageActor.props(out, manager)
        }
    }

    def withJsonBody[A](f: A => Result)(implicit request: Request[AnyContent], reads: Reads[A]) = {
    request.body.asJson.map { body =>
      Json.fromJson[A](body) match {
        case JsSuccess(a, path) => f(a)
        case e @ JsError(_) => Redirect(routes.Messageboard.mainload())
      }
    }.getOrElse(Redirect(routes.Messageboard.mainload()))
  }

    def validate = Action { implicit request =>
    withJsonBody[UserData] { ud =>
      if (ApplicationInMemoryModel.validateUser(ud.username, ud.password)) {
        Ok(Json.toJson(true))
          .withSession("username" -> ud.username, "csrfToken" -> play.filters.csrf.CSRF.getToken.map(_.value).getOrElse(""))
      } else {
        Ok(Json.toJson(false))
            }
        }
    }

    def createUser = Action { implicit request => 
        withJsonBody[UserData] { ud =>
        if (ApplicationInMemoryModel.createUser(ud.username, ud.password)) {
            Ok(Json.toJson(true))
                .withSession("username" -> ud.username, "csrfToken" -> play.filters.csrf.CSRF.getToken.map(_.value).getOrElse(""))
            } else {
            Ok(Json.toJson(false))
            } 
        }
    }
}