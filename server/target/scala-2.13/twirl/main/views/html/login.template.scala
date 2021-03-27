
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
<div style="bottom:0; margin-top:200px; margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  """),_display_(/*22.4*/helper/*22.10*/.form(action = routes.Application.createUserForm())/*22.61*/ {_display_(Seq[Any](format.raw/*22.63*/("""
		"""),_display_(/*23.4*/helper/*23.10*/.CSRF.formField),format.raw/*23.25*/("""
    """),format.raw/*24.5*/("""<h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Create Username</h3>
    <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
		"""),_display_(/*26.4*/helper/*26.10*/.inputText(loginForm("Username"), Symbol("id") -> "create-username")),format.raw/*26.78*/("""
		"""),_display_(/*27.4*/helper/*27.10*/.inputPassword(loginForm("Password"), Symbol("id") -> "create-pass")),format.raw/*27.78*/("""
		"""),format.raw/*28.3*/("""<div class="form-actions">
			<button type="submit">Create User</button>
    </div>
  </div>
	""")))}),format.raw/*32.3*/("""
"""),format.raw/*33.1*/("""</div>
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
                  DATE: 2021-03-25T14:45:28.953362
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/login.scala.html
                  HASH: 6346d48f00f6608b594606e04e7fcfbe65399f39
                  MATRIX: 766->1|941->83|968->85|989->98|1028->100|1057->103|1458->478|1473->484|1535->537|1575->539|1607->545|1622->551|1658->566|1690->572|1705->578|1792->644|1822->648|1837->654|1924->720|1954->723|2063->802|2093->805|2277->963|2292->969|2352->1020|2392->1022|2422->1026|2437->1032|2473->1047|2505->1052|2726->1247|2741->1253|2830->1321|2860->1325|2875->1331|2964->1399|2994->1402|3119->1497|3147->1498
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|35->11|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|38->14|38->14|39->15|42->18|43->19|46->22|46->22|46->22|46->22|47->23|47->23|47->23|48->24|50->26|50->26|50->26|51->27|51->27|51->27|52->28|56->32|57->33
                  -- GENERATED --
              */
          