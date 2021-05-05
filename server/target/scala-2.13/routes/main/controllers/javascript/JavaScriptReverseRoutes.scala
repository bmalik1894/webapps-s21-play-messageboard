// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/conf/routes
// @DATE:Tue May 04 08:38:43 CDT 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:46
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:47
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "versionedAssets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseMessageboarddb(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def sendMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.sendMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessageDB"})
        }
      """
    )
  
    // @LINE:35
    def messageList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.messageList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messageListDB"})
        }
      """
    )
  
    // @LINE:32
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createDB"})
        }
      """
    )
  
    // @LINE:34
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.getUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userListDB"})
        }
      """
    )
  
    // @LINE:30
    def mainload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.mainload",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messageboardDB"})
        }
      """
    )
  
    // @LINE:36
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logoutDB"})
        }
      """
    )
  
    // @LINE:31
    def validate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboarddb.validate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateDB"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseWebSocket(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def socket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebSocket.socket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "CanvasSocket"})
        }
      """
    )
  
    // @LINE:20
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebSocket.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Canvas"})
        }
      """
    )
  
  }

  // @LINE:42
  class ReverseDrawSocket(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def socket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DrawSocket.socket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drawSocket"})
        }
      """
    )
  
    // @LINE:42
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DrawSocket.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drawSjs"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def sendMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sendMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
        }
      """
    )
  
    // @LINE:17
    def deleteMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.deleteMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteMessage"})
        }
      """
    )
  
    // @LINE:11
    def validateUserForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.validateUserForm",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateForm"})
        }
      """
    )
  
    // @LINE:12
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createUser1"})
        }
      """
    )
  
    // @LINE:13
    def createUserForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.createUserForm",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createUserForm"})
        }
      """
    )
  
    // @LINE:14
    def addTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addTask",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addTask1"})
        }
      """
    )
  
    // @LINE:15
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.deleteTask",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteTask1"})
        }
      """
    )
  
    // @LINE:9
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout1"})
        }
      """
    )
  
    // @LINE:10
    def validateLoginPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.validateLoginPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateLogin"})
        }
      """
    )
  
    // @LINE:7
    def success: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.success",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "myPage"})
        }
      """
    )
  
    // @LINE:39
    def scalajsCanvas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.scalajsCanvas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "scalajsCanvas"})
        }
      """
    )
  
    // @LINE:6
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.login",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + """"})
          }
        
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseMessageboard(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def validate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboard.validate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateMB"})
        }
      """
    )
  
    // @LINE:25
    def socket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboard.socket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messageboardsocket"})
        }
      """
    )
  
    // @LINE:27
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboard.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "creatUserMB"})
        }
      """
    )
  
    // @LINE:24
    def mainload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Messageboard.mainload",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messageboard"})
        }
      """
    )
  
  }


}
