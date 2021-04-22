
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

object loginAjax extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[LoginData],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[LoginData])(implicit request:MessagesRequestHeader, flash:Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Login")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
  """),format.raw/*4.3*/("""<body style="background-color:rgba(161, 110, 209, .7);">

<div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  <div>
    <h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Login</h3>
  </div>
  <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
  """),_display_(/*11.4*/helper/*11.10*/.form(action = routes.Application.validateUserForm())/*11.63*/ {_display_(Seq[Any](format.raw/*11.65*/("""
    """),_display_(/*12.6*/helper/*12.12*/.CSRF.formField),format.raw/*12.27*/("""
    """),_display_(/*13.6*/helper/*13.12*/.inputText(loginForm("Username"), Symbol("id") -> "post-username")),format.raw/*13.78*/("""
		"""),_display_(/*14.4*/helper/*14.10*/.inputPassword(loginForm("Password"), Symbol("id") -> "post-pass")),format.raw/*14.76*/("""
		"""),format.raw/*15.3*/("""<div class="form-actions">
			<button type="submit">Login</button>
    </div>
  """)))}),format.raw/*18.4*/("""
  """),format.raw/*19.3*/("""</div>
</div>

<div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  <div>
    <h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Go to Canvas</h3>
  </div>
  <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
    <a href="/Canvas">Click Here</a>
  </div>
</div>
<div style="bottom:0; margin-top:100px; margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  """),_display_(/*31.4*/helper/*31.10*/.form(action = routes.Application.createUserForm())/*31.61*/ {_display_(Seq[Any](format.raw/*31.63*/("""
		"""),_display_(/*32.4*/helper/*32.10*/.CSRF.formField),format.raw/*32.25*/("""
    """),format.raw/*33.5*/("""<h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Create Username</h3>
    <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
		"""),_display_(/*35.4*/helper/*35.10*/.inputText(loginForm("Username"), Symbol("id") -> "create-username")),format.raw/*35.78*/("""
		"""),_display_(/*36.4*/helper/*36.10*/.inputPassword(loginForm("Password"), Symbol("id") -> "create-pass")),format.raw/*36.78*/("""
		"""),format.raw/*37.3*/("""<div class="form-actions">
			<button type="submit">Create User</button>
    </div>
  </div>
	""")))}),format.raw/*41.3*/("""
"""),format.raw/*42.1*/("""</div>
  <div id="root2"></div>
</body>
""")))}))
      }
    }
  }

  def render(loginForm:Form[LoginData],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)(request,flash)

  def f:((Form[LoginData]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => (request,flash) => apply(loginForm)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-04-19T09:52:49.464317
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/loginAjax.scala.html
                  HASH: 4dc23686de2d18b8ef31fe87fe5b3d690148ffb6
                  MATRIX: 770->1|945->83|972->85|993->98|1032->100|1061->103|1462->478|1477->484|1539->537|1579->539|1611->545|1626->551|1662->566|1694->572|1709->578|1796->644|1826->648|1841->654|1928->720|1958->723|2069->804|2099->807|2658->1340|2673->1346|2733->1397|2773->1399|2803->1403|2818->1409|2854->1424|2886->1429|3107->1624|3122->1630|3211->1698|3241->1702|3256->1708|3345->1776|3375->1779|3500->1874|3528->1875
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|35->11|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|38->14|38->14|39->15|42->18|43->19|55->31|55->31|55->31|55->31|56->32|56->32|56->32|57->33|59->35|59->35|59->35|60->36|60->36|60->36|61->37|65->41|66->42
                  -- GENERATED --
              */
          