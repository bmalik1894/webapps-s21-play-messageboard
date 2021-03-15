
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(implicit flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(/*7.13*/title),format.raw/*7.18*/("""</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.versioned("images/favicon.png")),format.raw/*9.100*/("""">

    <!-- Libraries for React -->
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
  </head>
  <body>
    """),_display_(/*16.6*/flash/*16.11*/.get("error")),format.raw/*16.24*/("""
  	"""),_display_(/*17.5*/flash/*17.10*/.get("success")),format.raw/*17.25*/("""
    """),_display_(/*18.6*/content),format.raw/*18.13*/("""
    """),_display_(/*19.6*/scalajs/*19.13*/.html.scripts("play-client", routes.Assets.versioned(_).toString, name => getClass.getResource(s"/public/$name") != null)),format.raw/*19.134*/("""
  """),format.raw/*20.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(flash)

  def f:((String) => (Html) => (Flash) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (flash) => apply(title)(content)(flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-15T11:17:43.890968
                  SOURCE: /users/bmalik/github/webapps/webapps-s21-play-messageboard/server/app/views/main.scala.html
                  HASH: 3bd160d52992fe877cc3fd0fca6081867c038e96
                  MATRIX: 739->1|886->55|913->56|984->101|1009->106|1093->164|1107->170|1168->211|1251->268|1265->274|1325->313|1604->568|1618->573|1652->586|1683->591|1697->596|1733->611|1765->617|1793->624|1825->630|1841->637|1984->758|2014->761
                  LINES: 21->1|26->2|27->3|31->7|31->7|32->8|32->8|32->8|33->9|33->9|33->9|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|43->19|43->19|43->19|44->20
                  -- GENERATED --
              */
          