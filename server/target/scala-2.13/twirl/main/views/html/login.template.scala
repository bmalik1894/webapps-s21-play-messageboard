
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[LoginData],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

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
                  DATE: 2021-04-19T09:52:49.296696
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/login.scala.html
                  HASH: 4dc23686de2d18b8ef31fe87fe5b3d690148ffb6
                  MATRIX: 766->1|941->83|968->85|989->98|1028->100|1057->103|1458->478|1473->484|1535->537|1575->539|1607->545|1622->551|1658->566|1690->572|1705->578|1792->644|1822->648|1837->654|1924->720|1954->723|2065->804|2095->807|2654->1340|2669->1346|2729->1397|2769->1399|2799->1403|2814->1409|2850->1424|2882->1429|3103->1624|3118->1630|3207->1698|3237->1702|3252->1708|3341->1776|3371->1779|3496->1874|3524->1875
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|35->11|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|38->14|38->14|39->15|42->18|43->19|55->31|55->31|55->31|55->31|56->32|56->32|56->32|57->33|59->35|59->35|59->35|60->36|60->36|60->36|61->37|65->41|66->42
                  -- GENERATED --
              */
          