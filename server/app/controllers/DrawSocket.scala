package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.data._
import play.api.libs.json
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.actor.Props
import actors.DrawActor
import actors.DrawManager

@Singleton
class DrawSocket @Inject()(cc: MessagesControllerComponents)(implicit system: ActorSystem, mat:Materializer) extends MessagesAbstractController(cc) { 
    val manager = system.actorOf(Props[DrawManager], "DrawManager")
    
    def index = Action { implicit request =>
        Ok(views.html.task11())
    }
    
    def socket = WebSocket.accept[String,String] { request =>
        ActorFlow.actorRef { out =>
            DrawActor.props(out, manager)
        }
    }
}
