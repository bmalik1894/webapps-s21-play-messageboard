
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

object scalajscanvas extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash:Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Scalajs Canvas Game")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""
"""),format.raw/*4.1*/("""<body id="sjsbody" style="background-image: url(https://image.shutterstock.com/image-photo/mountains-under-mist-morning-amazing-600w-1725825019.jpg); background-size:100% 100%; ">
    <h3 id="title" style="margin-left: auto; margin-right: auto; display: block;">Canvas Game - Use WASD to collect the pellets before time runs out!</h3>
    <div>
        <button id='startButton' style="margin-left: auto; margin-right: auto; display: block;" onclick='initializeGame()'>Start Game</button>
        <div style="background-color: white; margin-left: auto; margin-right: auto; display: block; width: 500px;" width="500">
            <span>Time left: </span>
            <span id="timer">00</span>
            <span id="points" style="float:right">0</span>
            <span style="float:right; padding-right: 10px;">Points </span><br>
        </div>
        <canvas width="500" height="500" id="scalajs-canvas" style="margin-left: auto; margin-right: auto; display: block;"></canvas>
    </div>
    <div style="text-align:center; position: relative; bottom:0; width:100%; background-color: rgba(255, 255, 255, 1)">
        <a href=""""),_display_(/*17.19*/routes/*17.25*/.Application.logout()),format.raw/*17.46*/("""" id="logout">Go back</a>
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
                  DATE: 2021-04-28T15:58:03.684253
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/scalajscanvas.scala.html
                  HASH: 4ba0b40faa18f59bae1c0b19f5c54f6fe58e2948
                  MATRIX: 750->1|892->50|919->52|954->79|993->81|1020->82|2175->1210|2190->1216|2232->1237
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|41->17|41->17|41->17
                  -- GENERATED --
              */
          