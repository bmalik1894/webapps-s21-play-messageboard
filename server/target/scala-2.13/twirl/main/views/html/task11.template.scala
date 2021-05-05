
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

object task11 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash:Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Scalajs Drawing")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
"""),format.raw/*4.1*/("""<body id="sjsdraw" style="background-image: url(https://image.shutterstock.com/image-photo/mountains-under-mist-morning-amazing-600w-1725825019.jpg); background-size:100% 100%; ">
    <h3 id="title" style="margin-left: auto; margin-right: auto; display: block;">Canvas Game - Draw with friends!</h3>
    <input type="hidden" id="ws-route" value=""""),_display_(/*6.48*/routes/*6.54*/.DrawSocket.socket().absoluteURL()),format.raw/*6.88*/("""">
    <div>
        <canvas width="500" height="500" id="scalajs-draw" style="margin-left: auto; margin-right: auto; display: block;"></canvas>
        <canvas width="1" height="1" id="scalajs-canvas" style="margin-left: auto; margin-right: auto; display: block;"></canvas>
        <input type="color" width="500" id="colorpicker" style="margin-left: auto; margin-right: auto; display: block;">
        <input type="range" width="500" min="2" max="10" defaultValue="5"id="sizepicker" style="margin-left: auto; margin-right: auto; display: block;">
    </div>
    <div style="text-align:center; position: relative; bottom:0; width:100%; background-color: rgba(255, 255, 255, 1)">
        <a href=""""),_display_(/*14.19*/routes/*14.25*/.Application.logout()),format.raw/*14.46*/("""" id="logout">Go back</a>
    </div>
</body>
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
                  DATE: 2021-05-05T12:56:27.468937
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/task11.scala.html
                  HASH: 889b3aa0be724257a00d34bfe23cce153b486e00
                  MATRIX: 743->1|885->50|912->52|943->75|982->77|1009->78|1382->425|1396->431|1450->465|2175->1163|2190->1169|2232->1190
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|30->6|30->6|30->6|38->14|38->14|38->14
                  -- GENERATED --
              */
          