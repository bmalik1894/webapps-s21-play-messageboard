// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/web-tasks-s21-bmalik1894/server/conf/routes
// @DATE:Sun Mar 14 19:03:49 CDT 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
