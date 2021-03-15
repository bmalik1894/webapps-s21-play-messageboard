// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/conf/routes
// @DATE:Mon Mar 15 11:17:43 CDT 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:21
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:22
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "versionedAssets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
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


}
