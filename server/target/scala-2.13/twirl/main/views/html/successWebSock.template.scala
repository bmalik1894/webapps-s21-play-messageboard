
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object successWebSock extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Messages")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>

<html>
  <body style="background-color:rgba(161, 110, 209, .7)">
    <input type="hidden" id="csrfToken" value=""""),_display_(/*8.49*/helper/*8.55*/.CSRF.getToken.value),format.raw/*8.75*/("""">
    <input type="hidden" id="validateUserRoute" value=""""),_display_(/*9.57*/routes/*9.63*/.Messageboard.validate()),format.raw/*9.87*/("""">
    <input type="hidden" id="createUserRoute" value=""""),_display_(/*10.55*/routes/*10.61*/.Messageboard.createUser()),format.raw/*10.87*/("""">
    <input type="hidden" id="ws-route" value=""""),_display_(/*11.48*/routes/*11.54*/.Messageboard.socket().absoluteURL()),format.raw/*11.90*/("""">
    <div id="maindiv"></div>
  </body>

  <script src=""""),_display_(/*15.17*/routes/*15.23*/.Assets.versioned("javascript/messageboard.js")),format.raw/*15.70*/(""""></script>
  <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
  <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
</html>
""")))}))
      }
    }
  }

  def render(request:RequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply()(request,flash)

  def f:(() => (RequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = () => (request,flash) => apply()(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-04-19T09:52:49.362498
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/successWebSock.scala.html
                  HASH: a342f91692cf64bb9aa8599a3154e96b39649297
                  MATRIX: 751->1|894->51|921->53|945->69|984->71|1011->72|1167->202|1181->208|1221->228|1306->287|1320->293|1364->317|1448->374|1463->380|1510->406|1587->456|1602->462|1659->498|1745->557|1760->563|1828->610
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|32->8|32->8|32->8|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|35->11|39->15|39->15|39->15
                  -- GENERATED --
              */
          