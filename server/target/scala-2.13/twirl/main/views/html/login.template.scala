
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
    <!--
  <h2>Login to the messageboard</h2>
  <form method="post" action=""""),_display_(/*7.32*/routes/*7.38*/.Application.validateLoginPost()),format.raw/*7.70*/("""">
    """),_display_(/*8.6*/helper/*8.12*/.CSRF.formField),format.raw/*8.27*/("""
    """),format.raw/*9.5*/("""Username: <input type='text' name='username'></input>
    <br>
    Password: <input type="password" name="password"></input>
    <br>
    <input type="submit"></input>
  </form>
  
  <h2>Create User</h2>
  <form method="post" action=""""),_display_(/*17.32*/routes/*17.38*/.Application.createUser()),format.raw/*17.63*/("""">
    """),_display_(/*18.6*/helper/*18.12*/.CSRF.formField),format.raw/*18.27*/("""
    """),format.raw/*19.5*/("""Username: <input type='text' name='newUsername'></input>
    <br>
    Password: <input type="password" name="newPassword"></input>
    <br>
    <input type="submit"></input>
  </form>
-->
<div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  <div>
    <h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Login</h3>
  </div>
  <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
  """),_display_(/*31.4*/helper/*31.10*/.form(action = routes.Application.validateUserForm())/*31.63*/ {_display_(Seq[Any](format.raw/*31.65*/("""
    """),_display_(/*32.6*/helper/*32.12*/.CSRF.formField),format.raw/*32.27*/("""
    """),_display_(/*33.6*/helper/*33.12*/.inputText(loginForm("Username"))),format.raw/*33.45*/("""
		"""),_display_(/*34.4*/helper/*34.10*/.inputPassword(loginForm("Password"))),format.raw/*34.47*/("""
		"""),format.raw/*35.3*/("""<div class="form-actions">
			<button type="submit">Login</button>
		</div>
  """)))}),format.raw/*38.4*/("""
  """),format.raw/*39.3*/("""</div>
</div>
<div style="bottom:0; margin-top:200px; margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  """),_display_(/*42.4*/helper/*42.10*/.form(action = routes.Application.createUserForm())/*42.61*/ {_display_(Seq[Any](format.raw/*42.63*/("""
		"""),_display_(/*43.4*/helper/*43.10*/.CSRF.formField),format.raw/*43.25*/("""
    """),format.raw/*44.5*/("""<h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Create Username</h3>
    <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
		"""),_display_(/*46.4*/helper/*46.10*/.inputText(loginForm("Username"))),format.raw/*46.43*/("""
		"""),_display_(/*47.4*/helper/*47.10*/.inputPassword(loginForm("Password"))),format.raw/*47.47*/("""
		"""),format.raw/*48.3*/("""<div class="form-actions">
			<button type="submit">Create User</button>
    </div>
  </div>
	""")))}),format.raw/*52.3*/("""
"""),format.raw/*53.1*/("""</div>
  <div id="root2"></div>
</body>
""")))}),format.raw/*56.2*/("""
"""))
      }
    }
  }

  def render(loginForm:Form[LoginData],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)(request,flash)

  def f:((Form[LoginData]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => (request,flash) => apply(loginForm)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-15T11:17:43.855192
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/login.scala.html
                  HASH: 91b52ffc529958051d4053ab2b6af03e9a50a049
                  MATRIX: 766->1|941->83|968->85|989->98|1028->100|1057->103|1217->237|1231->243|1283->275|1316->283|1330->289|1365->304|1396->309|1658->544|1673->550|1719->575|1753->583|1768->589|1804->604|1836->609|2367->1114|2382->1120|2444->1173|2484->1175|2516->1181|2531->1187|2567->1202|2599->1208|2614->1214|2668->1247|2698->1251|2713->1257|2771->1294|2801->1297|2910->1376|2940->1379|3124->1537|3139->1543|3199->1594|3239->1596|3269->1600|3284->1606|3320->1621|3352->1626|3573->1821|3588->1827|3642->1860|3672->1864|3687->1870|3745->1907|3775->1910|3900->2005|3928->2006|3999->2047
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|31->7|31->7|31->7|32->8|32->8|32->8|33->9|41->17|41->17|41->17|42->18|42->18|42->18|43->19|55->31|55->31|55->31|55->31|56->32|56->32|56->32|57->33|57->33|57->33|58->34|58->34|58->34|59->35|62->38|63->39|66->42|66->42|66->42|66->42|67->43|67->43|67->43|68->44|70->46|70->46|70->46|71->47|71->47|71->47|72->48|76->52|77->53|80->56
                  -- GENERATED --
              */
          