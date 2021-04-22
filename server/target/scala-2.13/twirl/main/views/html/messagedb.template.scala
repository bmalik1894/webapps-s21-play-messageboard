
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

object messagedb extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

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
    <input type="hidden" id="validateUserRoute" value=""""),_display_(/*9.57*/routes/*9.63*/.Messageboarddb.validate()),format.raw/*9.89*/("""">
    <input type="hidden" id="createUserRoute" value=""""),_display_(/*10.55*/routes/*10.61*/.Messageboarddb.createUser()),format.raw/*10.89*/("""">
    <input type="hidden" id="listUsersRoute" value=""""),_display_(/*11.54*/routes/*11.60*/.Messageboarddb.createUser()),format.raw/*11.88*/("""">
    <input type="hidden" id="sendRoute" value=""""),_display_(/*12.49*/routes/*12.55*/.Messageboarddb.sendMessage()),format.raw/*12.84*/("""">
    <input type="hidden" id="getMessagesRoute" value=""""),_display_(/*13.56*/routes/*13.62*/.Messageboarddb.messageList()),format.raw/*13.91*/("""">
    <div id="maindiv"></div>
  </body>

  <script src=""""),_display_(/*17.17*/routes/*17.23*/.Assets.versioned("javascript/mbdb.js")),format.raw/*17.62*/(""""></script>
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
                  DATE: 2021-04-22T11:04:59.318818
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/messagedb.scala.html
                  HASH: 54d4926073267dd2b5f97ad76db44ed11e009dba
                  MATRIX: 746->1|889->51|916->53|940->69|979->71|1006->72|1162->202|1176->208|1216->228|1301->287|1315->293|1361->319|1445->376|1460->382|1509->410|1592->466|1607->472|1656->500|1734->551|1749->557|1799->586|1884->644|1899->650|1949->679|2035->738|2050->744|2110->783
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|32->8|32->8|32->8|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|41->17|41->17|41->17
                  -- GENERATED --
              */
          