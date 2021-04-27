
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
"""),_display_(/*3.2*/main("Messages DB")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>

<html>
  <body style="background-color:rgba(255, 198, 42, 0.7)">
    <input type="hidden" id="csrfToken" value=""""),_display_(/*8.49*/helper/*8.55*/.CSRF.getToken.value),format.raw/*8.75*/("""">
    <input type="hidden" id="validateUserRoute" value=""""),_display_(/*9.57*/routes/*9.63*/.Messageboarddb.validate()),format.raw/*9.89*/("""">
    <input type="hidden" id="createUserRoute" value=""""),_display_(/*10.55*/routes/*10.61*/.Messageboarddb.createUser()),format.raw/*10.89*/("""">
    <input type="hidden" id="listUsersRoute" value=""""),_display_(/*11.54*/routes/*11.60*/.Messageboarddb.getUsers()),format.raw/*11.86*/("""">
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
                  DATE: 2021-04-26T20:17:39.659893
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/messagedb.scala.html
                  HASH: 8a06f76a483e850ebb7d99f79b180e8fdf53f497
                  MATRIX: 746->1|889->51|916->53|943->72|982->74|1009->75|1165->205|1179->211|1219->231|1304->290|1318->296|1364->322|1448->379|1463->385|1512->413|1595->469|1610->475|1657->501|1735->552|1750->558|1800->587|1885->645|1900->651|1950->680|2036->739|2051->745|2111->784
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|32->8|32->8|32->8|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|41->17|41->17|41->17
                  -- GENERATED --
              */
          