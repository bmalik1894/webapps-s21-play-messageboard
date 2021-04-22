
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

object canvaspage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash:Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Canvas Game")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
"""),format.raw/*4.1*/("""<body style="background-image: url(https://image.shutterstock.com/image-photo/mountains-under-mist-morning-amazing-600w-1725825019.jpg); background-size:100% 100%;">
    <h3 id="title" style="left:50%">Canvas</p>
        <input type="hidden" id="ws-route" value=""""),_display_(/*6.52*/routes/*6.58*/.WebSocket.socket().absoluteURL()),format.raw/*6.91*/("""">
        <canvas width="1280" height="1024" id="canvasId">
    </canvas>
    <div style="text-align:center; position: relative; bottom:0; width:100%; background-color: rgba(0, 0, 0, 1)">
        <a href=""""),_display_(/*10.19*/routes/*10.25*/.Application.logout()),format.raw/*10.46*/("""" id="logout">Go back</a>
    </div>
    <script src=""""),_display_(/*12.19*/routes/*12.25*/.Assets.versioned("javascript/canvas.js")),format.raw/*12.66*/(""""></script>
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
                  DATE: 2021-04-19T09:52:49.432435
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/canvaspage.scala.html
                  HASH: 1283458d6cf9280a448c88ad2fd5eb241c6d9c79
                  MATRIX: 747->1|889->50|916->52|943->71|982->73|1009->74|1299->338|1313->344|1366->377|1600->584|1615->590|1657->611|1739->666|1754->672|1816->713
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|30->6|30->6|30->6|34->10|34->10|34->10|36->12|36->12|36->12
                  -- GENERATED --
              */
          