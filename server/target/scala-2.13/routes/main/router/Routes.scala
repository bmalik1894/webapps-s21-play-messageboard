// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/conf/routes
// @DATE:Sat Apr 10 20:10:38 CDT 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_2: controllers.Application,
  // @LINE:20
  WebSocket_1: controllers.WebSocket,
  // @LINE:24
  Messageboard_0: controllers.Messageboard,
  // @LINE:30
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_2: controllers.Application,
    // @LINE:20
    WebSocket_1: controllers.WebSocket,
    // @LINE:24
    Messageboard_0: controllers.Messageboard,
    // @LINE:30
    Assets_3: controllers.Assets
  ) = this(errorHandler, Application_2, WebSocket_1, Messageboard_0, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_2, WebSocket_1, Messageboard_0, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """myPage""", """controllers.Application.success"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout1""", """controllers.Application.logout"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateLogin""", """controllers.Application.validateLoginPost"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateForm""", """controllers.Application.validateUserForm"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUser1""", """controllers.Application.createUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserForm""", """controllers.Application.createUserForm"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addTask1""", """controllers.Application.addTask"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteTask1""", """controllers.Application.deleteTask"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessage""", """controllers.Application.sendMessage"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteMessage""", """controllers.Application.deleteMessage"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Canvas""", """controllers.WebSocket.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """CanvasSocket""", """controllers.WebSocket.socket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messageboard""", """controllers.Messageboard.mainload"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messageboardsocket""", """controllers.Messageboard.socket"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateMB""", """controllers.Messageboard.validate"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """creatUserMB""", """controllers.Messageboard.createUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """versionedAssets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_login0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_login0_invoker = createInvoker(
    Application_2.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_success1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("myPage")))
  )
  private[this] lazy val controllers_Application_success1_invoker = createInvoker(
    Application_2.success,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "success",
      Nil,
      "GET",
      this.prefix + """myPage""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_login2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login2_invoker = createInvoker(
    Application_2.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_logout3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout1")))
  )
  private[this] lazy val controllers_Application_logout3_invoker = createInvoker(
    Application_2.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout1""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_validateLoginPost4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateLogin")))
  )
  private[this] lazy val controllers_Application_validateLoginPost4_invoker = createInvoker(
    Application_2.validateLoginPost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "validateLoginPost",
      Nil,
      "POST",
      this.prefix + """validateLogin""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_validateUserForm5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateForm")))
  )
  private[this] lazy val controllers_Application_validateUserForm5_invoker = createInvoker(
    Application_2.validateUserForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "validateUserForm",
      Nil,
      "POST",
      this.prefix + """validateForm""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_createUser6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUser1")))
  )
  private[this] lazy val controllers_Application_createUser6_invoker = createInvoker(
    Application_2.createUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "createUser",
      Nil,
      "POST",
      this.prefix + """createUser1""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_createUserForm7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserForm")))
  )
  private[this] lazy val controllers_Application_createUserForm7_invoker = createInvoker(
    Application_2.createUserForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "createUserForm",
      Nil,
      "POST",
      this.prefix + """createUserForm""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_addTask8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addTask1")))
  )
  private[this] lazy val controllers_Application_addTask8_invoker = createInvoker(
    Application_2.addTask,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addTask",
      Nil,
      "POST",
      this.prefix + """addTask1""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_deleteTask9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteTask1")))
  )
  private[this] lazy val controllers_Application_deleteTask9_invoker = createInvoker(
    Application_2.deleteTask,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "deleteTask",
      Nil,
      "POST",
      this.prefix + """deleteTask1""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Application_sendMessage10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessage")))
  )
  private[this] lazy val controllers_Application_sendMessage10_invoker = createInvoker(
    Application_2.sendMessage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sendMessage",
      Nil,
      "POST",
      this.prefix + """sendMessage""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Application_deleteMessage11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteMessage")))
  )
  private[this] lazy val controllers_Application_deleteMessage11_invoker = createInvoker(
    Application_2.deleteMessage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "deleteMessage",
      Nil,
      "POST",
      this.prefix + """deleteMessage""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_WebSocket_index12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Canvas")))
  )
  private[this] lazy val controllers_WebSocket_index12_invoker = createInvoker(
    WebSocket_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocket",
      "index",
      Nil,
      "GET",
      this.prefix + """Canvas""",
      """ WebSocket Routes""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_WebSocket_socket13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("CanvasSocket")))
  )
  private[this] lazy val controllers_WebSocket_socket13_invoker = createInvoker(
    WebSocket_1.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocket",
      "socket",
      Nil,
      "GET",
      this.prefix + """CanvasSocket""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Messageboard_mainload14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messageboard")))
  )
  private[this] lazy val controllers_Messageboard_mainload14_invoker = createInvoker(
    Messageboard_0.mainload,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Messageboard",
      "mainload",
      Nil,
      "GET",
      this.prefix + """messageboard""",
      """ REACT Messageboard Routes""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Messageboard_socket15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messageboardsocket")))
  )
  private[this] lazy val controllers_Messageboard_socket15_invoker = createInvoker(
    Messageboard_0.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Messageboard",
      "socket",
      Nil,
      "GET",
      this.prefix + """messageboardsocket""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Messageboard_validate16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateMB")))
  )
  private[this] lazy val controllers_Messageboard_validate16_invoker = createInvoker(
    Messageboard_0.validate,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Messageboard",
      "validate",
      Nil,
      "POST",
      this.prefix + """validateMB""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Messageboard_createUser17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("creatUserMB")))
  )
  private[this] lazy val controllers_Messageboard_createUser17_invoker = createInvoker(
    Messageboard_0.createUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Messageboard",
      "createUser",
      Nil,
      "POST",
      this.prefix + """creatUserMB""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Assets_at18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at18_invoker = createInvoker(
    Assets_3.at(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Prefix must match `play.assets.urlPrefix`""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Assets_versioned19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("versionedAssets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned19_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """versionedAssets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_login0_route(params@_) =>
      call { 
        controllers_Application_login0_invoker.call(Application_2.login)
      }
  
    // @LINE:7
    case controllers_Application_success1_route(params@_) =>
      call { 
        controllers_Application_success1_invoker.call(Application_2.success)
      }
  
    // @LINE:8
    case controllers_Application_login2_route(params@_) =>
      call { 
        controllers_Application_login2_invoker.call(Application_2.login)
      }
  
    // @LINE:9
    case controllers_Application_logout3_route(params@_) =>
      call { 
        controllers_Application_logout3_invoker.call(Application_2.logout)
      }
  
    // @LINE:10
    case controllers_Application_validateLoginPost4_route(params@_) =>
      call { 
        controllers_Application_validateLoginPost4_invoker.call(Application_2.validateLoginPost)
      }
  
    // @LINE:11
    case controllers_Application_validateUserForm5_route(params@_) =>
      call { 
        controllers_Application_validateUserForm5_invoker.call(Application_2.validateUserForm)
      }
  
    // @LINE:12
    case controllers_Application_createUser6_route(params@_) =>
      call { 
        controllers_Application_createUser6_invoker.call(Application_2.createUser)
      }
  
    // @LINE:13
    case controllers_Application_createUserForm7_route(params@_) =>
      call { 
        controllers_Application_createUserForm7_invoker.call(Application_2.createUserForm)
      }
  
    // @LINE:14
    case controllers_Application_addTask8_route(params@_) =>
      call { 
        controllers_Application_addTask8_invoker.call(Application_2.addTask)
      }
  
    // @LINE:15
    case controllers_Application_deleteTask9_route(params@_) =>
      call { 
        controllers_Application_deleteTask9_invoker.call(Application_2.deleteTask)
      }
  
    // @LINE:16
    case controllers_Application_sendMessage10_route(params@_) =>
      call { 
        controllers_Application_sendMessage10_invoker.call(Application_2.sendMessage)
      }
  
    // @LINE:17
    case controllers_Application_deleteMessage11_route(params@_) =>
      call { 
        controllers_Application_deleteMessage11_invoker.call(Application_2.deleteMessage)
      }
  
    // @LINE:20
    case controllers_WebSocket_index12_route(params@_) =>
      call { 
        controllers_WebSocket_index12_invoker.call(WebSocket_1.index)
      }
  
    // @LINE:21
    case controllers_WebSocket_socket13_route(params@_) =>
      call { 
        controllers_WebSocket_socket13_invoker.call(WebSocket_1.socket)
      }
  
    // @LINE:24
    case controllers_Messageboard_mainload14_route(params@_) =>
      call { 
        controllers_Messageboard_mainload14_invoker.call(Messageboard_0.mainload)
      }
  
    // @LINE:25
    case controllers_Messageboard_socket15_route(params@_) =>
      call { 
        controllers_Messageboard_socket15_invoker.call(Messageboard_0.socket)
      }
  
    // @LINE:26
    case controllers_Messageboard_validate16_route(params@_) =>
      call { 
        controllers_Messageboard_validate16_invoker.call(Messageboard_0.validate)
      }
  
    // @LINE:27
    case controllers_Messageboard_createUser17_route(params@_) =>
      call { 
        controllers_Messageboard_createUser17_invoker.call(Messageboard_0.createUser)
      }
  
    // @LINE:30
    case controllers_Assets_at18_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_at18_invoker.call(Assets_3.at(file))
      }
  
    // @LINE:31
    case controllers_Assets_versioned19_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned19_invoker.call(Assets_3.versioned(path, file))
      }
  }
}
