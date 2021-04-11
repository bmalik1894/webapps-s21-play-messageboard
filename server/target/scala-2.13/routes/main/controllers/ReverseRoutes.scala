// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/conf/routes
// @DATE:Sat Apr 10 20:10:38 CDT 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:24
  class ReverseMessageboard(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def validate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateMB")
    }
  
    // @LINE:25
    def socket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messageboardsocket")
    }
  
    // @LINE:27
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "creatUserMB")
    }
  
    // @LINE:24
    def mainload(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messageboard")
    }
  
  }

  // @LINE:30
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def at(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:31
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "versionedAssets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:20
  class ReverseWebSocket(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def socket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "CanvasSocket")
    }
  
    // @LINE:20
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "Canvas")
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def sendMessage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessage")
    }
  
    // @LINE:17
    def deleteMessage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteMessage")
    }
  
    // @LINE:11
    def validateUserForm(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateForm")
    }
  
    // @LINE:12
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUser1")
    }
  
    // @LINE:13
    def createUserForm(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUserForm")
    }
  
    // @LINE:14
    def addTask(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addTask1")
    }
  
    // @LINE:15
    def deleteTask(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteTask1")
    }
  
    // @LINE:9
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout1")
    }
  
    // @LINE:10
    def validateLoginPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateLogin")
    }
  
    // @LINE:7
    def success(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "myPage")
    }
  
    // @LINE:6
    def login(): Call = {
    
      () match {
      
        // @LINE:6
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
  }


}
