// @GENERATOR:play-routes-compiler
// @SOURCE:/users/bmalik/github/webapps/webapps-s21-play-messageboard/server/conf/routes
// @DATE:Sat Apr 10 20:10:38 CDT 2021


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
