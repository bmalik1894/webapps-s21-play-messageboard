package canvasjs

import org.scalajs.dom
import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import scala.scalajs.js.timers
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.html
import slinky.web.html._
import scala.util.Random
import scala.tools.nsc.doc.html.HtmlTags

object CanvasGame {

  case class Point(var x:Double, var y:Double)

  val rand = new Random

  var playing = false
  var points = 0
  var timeRemaining = 60
  var timerId:timers.SetIntervalHandle = null
  var pellets = Seq[Point]()
  val playerLoc = Point(235, 235)    


  val canvas = dom.document.getElementById("scalajs-canvas").asInstanceOf[html.Canvas]
  val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  val scoreBoard = document.getElementById("points")
  val clock = document.getElementById("timer")
  

  def main(args: Array[String]): Unit = {
    if (dom.document.getElementById("scalajs-canvas") != null) {
      // setup
      context.fillStyle = "white"
      context.fillRect(0, 0, 500, 500)

      def updateCanvas(event: dom.KeyboardEvent): Unit = {
        val dir = event.key
        if (playing && dir != "garbage") {
          context.fillStyle = "white"
          context.fillRect(0, 0, 500, 500)
          if (dir == "a" && playerLoc.x > 5) {
            playerLoc.x = playerLoc.x - 5
          } else if (dir == "d" && playerLoc.x < 465) {
            playerLoc.x = playerLoc.x + 5
          } else if (dir == "s" && playerLoc.y < 465) {
            playerLoc.y = playerLoc.y + 5
          } else if (dir == "w" && playerLoc.y > 5) {
            playerLoc.y = playerLoc.y - 5
          }
      
          // draw pellets
          context.fillStyle = "green"
          pellets.foreach( p => context.fillRect(p.x, p.y, 10, 10))

          // draw player
          context.fillStyle = "black"
          context.fillRect(playerLoc.x, playerLoc.y, 30,30)

          // detect collisions
          collisionDetection()

          // check win conditions
          if (pellets.length == 0) {
            playing = false
            timers.clearInterval(timerId)
            points += timeRemaining * 10
            updatePoints()
            context.fillStyle = "black"
            context.fillText("You win!", 235, 250)
          }

        }
      }
      
      // key event function call
      dom.document.onkeypress = (event:dom.KeyboardEvent) => updateCanvas(event)
      
      }
    }
  
  @JSExportTopLevel("initializeGame")
  def initializeGame(): Unit = {
    println("Starting Game")
    //buildEnemies()
    buildPellets(15)
    playing = true
    resetObjects()
    timeRemaining = 30
    points = 0
    updatePoints()
    timerId = timers.setInterval(1000)(startCountdown())
  }

  def resetObjects() {
    playerLoc.x = 235
    playerLoc.y = 235
    
    context.fillStyle = "white"
    context.fillRect(0,0,500,500)

    context.fillStyle = "black"
    context.fillRect(playerLoc.x, playerLoc.y, 30, 30)
    
    context.fillStyle = "green"
    pellets.foreach( p => context.fillRect(p.x, p.y, 10, 10))
  }

  def startCountdown() {
    if (timeRemaining == -1)  {
      playing = false
      context.fillStyle = "black"
      context.fillText("GAME OVER", 220, 250, 200.00)
      timers.clearInterval(timerId)
    } else {
      clock.innerHTML = timeRemaining.toString()
      timeRemaining -= 1
    }
  }

  def collisionDetection() {
    for (i <- 0 until pellets.length) {
      if ((playerLoc.x - pellets(i).x).abs < 30 && (playerLoc.y - pellets(i).y).abs < 30) {
        points += 10
        updatePoints()
        pellets = pellets.filterNot(p => p == pellets(i))
      }
    }
  }

  def buildPellets(amt:Int) {
    pellets = Seq[Point]()
    for (i <- 1 until amt) {
      pellets = pellets :+ Point(rand.nextInt(490), rand.nextInt(490))
    }
  }

  def updatePoints() = scoreBoard.innerHTML = points.toString() 

}