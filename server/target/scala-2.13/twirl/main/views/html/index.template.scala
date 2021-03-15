
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String)(implicit flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Play with Scala.js")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""

  """),format.raw/*5.3*/("""<h2>Play and Scala.js share a same message</h2>
  <ul>
    <li>Play shouts out: <em>"""),_display_(/*7.31*/message),format.raw/*7.38*/("""</em></li>
    <li>Scala.js shouts out: <em id="scalajsShoutOut"></em></li>
    <li><form method="GET" action=""""),_display_(/*9.37*/routes/*9.43*/.Application.login()),format.raw/*9.63*/(""""><input type='submit' value='Login'></input></form></li>
  </ul>

  <div id="root"></div>
""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(message:String,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(message)(flash)

  def f:((String) => (Flash) => play.twirl.api.HtmlFormat.Appendable) = (message) => (flash) => apply(message)(flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-15T11:17:43.878804
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/index.scala.html
                  HASH: c196354cb710b8c82059a6f7eb803c67be6a36bd
                  MATRIX: 735->1|869->42|896->44|930->70|969->72|999->76|1110->161|1137->168|1275->280|1289->286|1329->306|1451->398
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|31->7|31->7|33->9|33->9|33->9|37->13
                  -- GENERATED --
              */
          