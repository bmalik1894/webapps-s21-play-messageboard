
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

object reactMain extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("TL4")/*3.13*/{_display_(Seq[Any](format.raw/*3.14*/("""
  """),format.raw/*11.5*/("""
  """),format.raw/*12.3*/("""<div id="react-root"></div>
  <script src=""""),_display_(/*13.17*/routes/*13.23*/.Assets.versioned("javascript/version4.js")),format.raw/*13.66*/(""""></script>
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
                  DATE: 2021-04-19T09:52:49.495927
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/reactMain.scala.html
                  HASH: c1a0e1bbc97d55cbc25cf7a644bf2c4a245275e3
                  MATRIX: 746->1|889->51|916->53|935->64|973->65|1003->605|1033->608|1104->652|1119->658|1183->701
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->11|29->12|30->13|30->13|30->13
                  -- GENERATED --
              */
          