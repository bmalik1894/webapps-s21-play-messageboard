// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/web-tasks-s21-bmalik1894/server/conf/routes
// @DATE:Sun Mar 14 19:03:49 CDT 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:21
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def at(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:22
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "versionedAssets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
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
