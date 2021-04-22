
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

object success extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[Seq[String],Seq[ApplicationInMemoryModel.Message],Seq[ApplicationInMemoryModel.Message],List[String],String,RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tasks:Seq[String], msgs:Seq[ApplicationInMemoryModel.Message], publics:Seq[ApplicationInMemoryModel.Message], userList:List[String], currUser:String)(implicit request: RequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Messages")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>

<html>
  <head>
  </head>
  <body style="background-image: url('../../public/images/bg.png'); background-color:rgba(161, 110, 209, .7)">
	
  <!-- SHOW MESSAGES -->
<div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  <h2 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Messages</h2>
  <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
  <h3>Public Messages</h3>
  <ul>
    """),_display_(/*17.6*/for((pub, i) <- publics.zipWithIndex) yield /*17.43*/ {_display_(Seq[Any](format.raw/*17.45*/("""
      """),format.raw/*18.7*/("""<!--if(pub.from == currUser)-->
      <li><b>"""),_display_(/*19.15*/pub/*19.18*/.body),format.raw/*19.23*/("""</b><br>"""),_display_(/*19.32*/pub/*19.35*/.from),format.raw/*19.40*/(""" """),format.raw/*19.41*/("""at """),_display_(/*19.45*/pub/*19.48*/.timestamp),format.raw/*19.58*/("""</li>
    """)))}),format.raw/*20.6*/("""
  """),format.raw/*21.3*/("""</ul>
  <h3>Private Messages for """),_display_(/*22.29*/currUser),format.raw/*22.37*/("""</h3>
  <ul>
    <!--#"""),format.raw/*24.10*/("""{"""),format.raw/*24.11*/("""if (msgs.isEmpty())"""),format.raw/*24.30*/("""}"""),format.raw/*24.31*/("""
      """),format.raw/*25.7*/("""<li>None yet.</li>
    #"""),format.raw/*26.6*/("""{"""),format.raw/*26.7*/("""/if"""),format.raw/*26.10*/("""}"""),format.raw/*26.11*/("""--> 
    """),_display_(/*27.6*/for((msg, i) <- msgs.zipWithIndex) yield /*27.40*/ {_display_(Seq[Any](format.raw/*27.42*/("""
      """),format.raw/*28.7*/("""<li><b>"""),_display_(/*28.15*/msg/*28.18*/.body),format.raw/*28.23*/("""</b><br>"""),_display_(/*28.32*/msg/*28.35*/.from),format.raw/*28.40*/(""" """),format.raw/*28.41*/("""at """),_display_(/*28.45*/msg/*28.48*/.timestamp),format.raw/*28.58*/("""</li>
      <form method="post" action=""""),_display_(/*29.36*/routes/*29.42*/.Application.deleteMessage()),format.raw/*29.70*/("""">
				"""),_display_(/*30.6*/helper/*30.12*/.CSRF.formField),format.raw/*30.27*/("""
				"""),format.raw/*31.5*/("""<input type="hidden" name="index" value=""""),_display_(/*31.47*/i),format.raw/*31.48*/(""""/>
				<input type="submit" value="Delete" id="delete-"""),_display_(/*32.53*/i),format.raw/*32.54*/(""""/>
			</form>
      """)))}),format.raw/*34.8*/("""
    """),format.raw/*35.5*/("""</ul>
  </div>
</div>
  <br><br>



  <!--  SENDING A MESSAGE -->
  <div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
    <div>
      <h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Send a Message</h3>
    </div>
    <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
    <form method="post" action=""""),_display_(/*48.34*/routes/*48.40*/.Application.sendMessage()),format.raw/*48.66*/("""">
          """),_display_(/*49.12*/helper/*49.18*/.CSRF.formField),format.raw/*49.33*/("""
          """),format.raw/*50.11*/("""To: 
          <select name='userList' id='dropdownusers'>
            <option name="public" value="public">Everyone</option>
            """),_display_(/*53.14*/for((user, i) <- userList.zipWithIndex) yield /*53.53*/ {_display_(Seq[Any](format.raw/*53.55*/("""
            """),format.raw/*54.13*/("""<option name=""""),_display_(/*54.28*/i),format.raw/*54.29*/("""" value=""""),_display_(/*54.39*/user),format.raw/*54.43*/("""">"""),_display_(/*54.46*/user),format.raw/*54.50*/("""</option>
          """)))}),format.raw/*55.12*/("""
          """),format.raw/*56.11*/("""</select>

          <br>
          Message: <input type="text" name="messageText"></input>
          <input type="submit" value="Send"></input>
        </form>
      </div>
    </div>

	  <footer style="text-align:center; position: absolute; bottom:0; left:50%; background-color: rgba(0, 0, 0, .3)">
		  <a href=""""),_display_(/*66.15*/routes/*66.21*/.Application.logout()),format.raw/*66.42*/("""" id="logout">Logout</a>
    </footer>
  </body>
</html>
""")))}))
      }
    }
  }

  def render(tasks:Seq[String],msgs:Seq[ApplicationInMemoryModel.Message],publics:Seq[ApplicationInMemoryModel.Message],userList:List[String],currUser:String,request:RequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tasks,msgs,publics,userList,currUser)(request,flash)

  def f:((Seq[String],Seq[ApplicationInMemoryModel.Message],Seq[ApplicationInMemoryModel.Message],List[String],String) => (RequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tasks,msgs,publics,userList,currUser) => (request,flash) => apply(tasks,msgs,publics,userList,currUser)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-04-19T09:52:49.521183
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/success.scala.html
                  HASH: 73e52fa8b7233426336911241b418109958c5ae6
                  MATRIX: 852->1|1143->199|1170->201|1194->217|1233->219|1260->220|1804->738|1857->775|1897->777|1931->784|2004->830|2016->833|2042->838|2078->847|2090->850|2116->855|2145->856|2176->860|2188->863|2219->873|2260->884|2290->887|2351->921|2380->929|2430->951|2459->952|2506->971|2535->972|2569->979|2620->1003|2648->1004|2679->1007|2708->1008|2744->1018|2794->1052|2834->1054|2868->1061|2903->1069|2915->1072|2941->1077|2977->1086|2989->1089|3015->1094|3044->1095|3075->1099|3087->1102|3118->1112|3186->1153|3201->1159|3250->1187|3284->1195|3299->1201|3335->1216|3367->1221|3436->1263|3458->1264|3541->1320|3563->1321|3615->1343|3647->1348|4106->1780|4121->1786|4168->1812|4209->1826|4224->1832|4260->1847|4299->1858|4465->1997|4520->2036|4560->2038|4601->2051|4643->2066|4665->2067|4702->2077|4727->2081|4757->2084|4782->2088|4834->2109|4873->2120|5215->2435|5230->2441|5272->2462
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|41->17|41->17|41->17|42->18|43->19|43->19|43->19|43->19|43->19|43->19|43->19|43->19|43->19|43->19|44->20|45->21|46->22|46->22|48->24|48->24|48->24|48->24|49->25|50->26|50->26|50->26|50->26|51->27|51->27|51->27|52->28|52->28|52->28|52->28|52->28|52->28|52->28|52->28|52->28|52->28|52->28|53->29|53->29|53->29|54->30|54->30|54->30|55->31|55->31|55->31|56->32|56->32|58->34|59->35|72->48|72->48|72->48|73->49|73->49|73->49|74->50|77->53|77->53|77->53|78->54|78->54|78->54|78->54|78->54|78->54|78->54|79->55|80->56|90->66|90->66|90->66
                  -- GENERATED --
              */
          