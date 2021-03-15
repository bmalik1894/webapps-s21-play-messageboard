
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
    <title>Success</title>
  </head>
  <body style="background-image: url('../../public/images/bg.png'); background-color:rgba(161, 110, 209, .7)">
	
	<!--<ul>
		"""),_display_(/*13.4*/for((task, i) <- tasks.zipWithIndex) yield /*13.40*/ {_display_(Seq[Any](format.raw/*13.42*/("""
			"""),format.raw/*14.4*/("""<li>"""),_display_(/*14.9*/task),format.raw/*14.13*/("""</li>
			<form method="post" action=""""),_display_(/*15.33*/routes/*15.39*/.Application.deleteTask()),format.raw/*15.64*/("""">
				"""),_display_(/*16.6*/helper/*16.12*/.CSRF.formField),format.raw/*16.27*/("""
				"""),format.raw/*17.5*/("""<input type="hidden" name="index" value=""""),_display_(/*17.47*/i),format.raw/*17.48*/(""""/>
				<input type="submit" value="Delete" id="delete-"""),_display_(/*18.53*/i),format.raw/*18.54*/(""""/>
			</form>
		""")))}),format.raw/*20.4*/("""
	"""),format.raw/*21.2*/("""</ul>
	
	<form method="post" action=""""),_display_(/*23.31*/routes/*23.37*/.Application.addTask()),format.raw/*23.59*/("""">
		"""),_display_(/*24.4*/helper/*24.10*/.CSRF.formField),format.raw/*24.25*/("""
		"""),format.raw/*25.3*/("""<input type="text" name="newTask"></input>
		<input type="submit"></input>
  </form>-->
  
  <!-- SHOW MESSAGES -->
<div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  <h2 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Messages</h2>
  <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
  <h3>Public Messages</h3>
  <ul>
    """),_display_(/*35.6*/for((pub, i) <- publics.zipWithIndex) yield /*35.43*/ {_display_(Seq[Any](format.raw/*35.45*/("""
      """),format.raw/*36.7*/("""<!--if(pub.from == currUser)-->
      <li><b>"""),_display_(/*37.15*/pub/*37.18*/.body),format.raw/*37.23*/("""</b><br>"""),_display_(/*37.32*/pub/*37.35*/.from),format.raw/*37.40*/(""" """),format.raw/*37.41*/("""at """),_display_(/*37.45*/pub/*37.48*/.timestamp),format.raw/*37.58*/("""</li>
    """)))}),format.raw/*38.6*/("""
  """),format.raw/*39.3*/("""</ul>
  <h3>Private Messages for """),_display_(/*40.29*/currUser),format.raw/*40.37*/("""</h3>
  <ul>
    <!--#"""),format.raw/*42.10*/("""{"""),format.raw/*42.11*/("""if (msgs.isEmpty())"""),format.raw/*42.30*/("""}"""),format.raw/*42.31*/("""
      """),format.raw/*43.7*/("""<li>None yet.</li>
    #"""),format.raw/*44.6*/("""{"""),format.raw/*44.7*/("""/if"""),format.raw/*44.10*/("""}"""),format.raw/*44.11*/("""--> 
    """),_display_(/*45.6*/for((msg, i) <- msgs.zipWithIndex) yield /*45.40*/ {_display_(Seq[Any](format.raw/*45.42*/("""
      """),format.raw/*46.7*/("""<li><b>"""),_display_(/*46.15*/msg/*46.18*/.body),format.raw/*46.23*/("""</b><br>"""),_display_(/*46.32*/msg/*46.35*/.from),format.raw/*46.40*/(""" """),format.raw/*46.41*/("""at """),_display_(/*46.45*/msg/*46.48*/.timestamp),format.raw/*46.58*/("""</li>
      <form method="post" action=""""),_display_(/*47.36*/routes/*47.42*/.Application.deleteMessage()),format.raw/*47.70*/("""">
				"""),_display_(/*48.6*/helper/*48.12*/.CSRF.formField),format.raw/*48.27*/("""
				"""),format.raw/*49.5*/("""<input type="hidden" name="index" value=""""),_display_(/*49.47*/i),format.raw/*49.48*/(""""/>
				<input type="submit" value="Delete" id="delete-"""),_display_(/*50.53*/i),format.raw/*50.54*/(""""/>
			</form>
      """)))}),format.raw/*52.8*/("""
    """),format.raw/*53.5*/("""</ul>
  </div>
</div>
  <br><br>



  <!--  SENDING A MESSAGE -->
  <div style="margin-left:30%; width:500px; background-color: rgba(255, 255, 255, .7); box-shadow:4px 4px black;">
  <div>
    <h3 style="text-align:center; width:100%; background-color: rgba(0, 0, 0, .7); color:white;">Send a Message</h3>
  </div>
  <div style="padding-left:20px; padding-bottom:20px; padding-right:20px;">
  <form method="post" action=""""),_display_(/*66.32*/routes/*66.38*/.Application.sendMessage()),format.raw/*66.64*/("""">
    """),_display_(/*67.6*/helper/*67.12*/.CSRF.formField),format.raw/*67.27*/("""
    """),format.raw/*68.5*/("""To: 
    <select name='userList' id='dropdownusers'>
        <option name="public" value="public">Everyone</option>
      """),_display_(/*71.8*/for((user, i) <- userList.zipWithIndex) yield /*71.47*/ {_display_(Seq[Any](format.raw/*71.49*/("""
        """),format.raw/*72.9*/("""<option name=""""),_display_(/*72.24*/i),format.raw/*72.25*/("""" value=""""),_display_(/*72.35*/user),format.raw/*72.39*/("""">"""),_display_(/*72.42*/user),format.raw/*72.46*/("""</option>
      """)))}),format.raw/*73.8*/("""
    """),format.raw/*74.5*/("""</select>
    <!--To: <input type="text" name="userTo"></input>-->
    <br>
    Message: <input type="text" name="messageText"></input>
    <input type="submit" value="Send"></input>
    </form>
    </div>
  </div>

	<footer style="text-align:center; position: absolute; bottom:0; left:50%;">
		<a href=""""),_display_(/*84.13*/routes/*84.19*/.Application.logout()),format.raw/*84.40*/("""" id="logout">Logout</a>
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
                  DATE: 2021-03-14T19:03:49.936205
                  SOURCE: /users/bmalik/github/webapps/web-tasks-s21-bmalik1894/server/app/views/success.scala.html
                  HASH: 503df7f114f8dbeb90bdd9d755fc2709ee4477d9
                  MATRIX: 852->1|1143->199|1170->201|1194->217|1233->219|1260->220|1482->416|1534->452|1574->454|1605->458|1636->463|1661->467|1726->505|1741->511|1787->536|1821->544|1836->550|1872->565|1904->570|1973->612|1995->613|2078->669|2100->670|2148->688|2177->690|2242->728|2257->734|2300->756|2332->762|2347->768|2383->783|2413->786|2892->1239|2945->1276|2985->1278|3019->1285|3092->1331|3104->1334|3130->1339|3166->1348|3178->1351|3204->1356|3233->1357|3264->1361|3276->1364|3307->1374|3348->1385|3378->1388|3439->1422|3468->1430|3518->1452|3547->1453|3594->1472|3623->1473|3657->1480|3708->1504|3736->1505|3767->1508|3796->1509|3832->1519|3882->1553|3922->1555|3956->1562|3991->1570|4003->1573|4029->1578|4065->1587|4077->1590|4103->1595|4132->1596|4163->1600|4175->1603|4206->1613|4274->1654|4289->1660|4338->1688|4372->1696|4387->1702|4423->1717|4455->1722|4524->1764|4546->1765|4629->1821|4651->1822|4703->1844|4735->1849|5184->2271|5199->2277|5246->2303|5280->2311|5295->2317|5331->2332|5363->2337|5512->2460|5567->2499|5607->2501|5643->2510|5685->2525|5707->2526|5744->2536|5769->2540|5799->2543|5824->2547|5871->2564|5903->2569|6235->2874|6250->2880|6292->2901
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|37->13|37->13|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|44->20|45->21|47->23|47->23|47->23|48->24|48->24|48->24|49->25|59->35|59->35|59->35|60->36|61->37|61->37|61->37|61->37|61->37|61->37|61->37|61->37|61->37|61->37|62->38|63->39|64->40|64->40|66->42|66->42|66->42|66->42|67->43|68->44|68->44|68->44|68->44|69->45|69->45|69->45|70->46|70->46|70->46|70->46|70->46|70->46|70->46|70->46|70->46|70->46|70->46|71->47|71->47|71->47|72->48|72->48|72->48|73->49|73->49|73->49|74->50|74->50|76->52|77->53|90->66|90->66|90->66|91->67|91->67|91->67|92->68|95->71|95->71|95->71|96->72|96->72|96->72|96->72|96->72|96->72|96->72|97->73|98->74|108->84|108->84|108->84
                  -- GENERATED --
              */
          