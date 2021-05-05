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
import edu.trinity.videoquizreact.shared.{Line, Point}

object CanvasGame {



  val rand = new Random

  // TASK 11 GLOBAL VARIABLES
  var initMousePos = Point(0, 0)
  var endMousePos = Point(0, 0)
  var currColor = "black"

  val colorpicker = dom.document.getElementById("colorpicker").asInstanceOf[html.Input]
  val sizepicker = dom.document.getElementById("sizepicker").asInstanceOf[html.Input]


  // TASK 10 GLOBAL VARIABLES
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


    ///////////////////// TASK 10 ///////////////////////////
    if (dom.document.getElementById("scalajs-canvas") != null && dom.document.getElementById("scalajs-draw") == null) {
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
    ///////////////////// TASK 11 ///////////////////////////
      else if (dom.document.getElementById("scalajs-draw") != null) {

        val drawvas = dom.document.getElementById("scalajs-draw").asInstanceOf[html.Canvas]
        val drawtext = drawvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
        
        var socketRoute = dom.document.getElementById("ws-route").asInstanceOf[html.Input].value
        //if(socketRoute.indexOf("https:") == -1) {
        //  socketRoute = socketRoute.replace("http", "ws")
        //}  else {
          socketRoute = socketRoute.replace("http", "wss")
        //}

        val socket = new dom.WebSocket(socketRoute)

        drawtext.fillStyle = "white"
        drawtext.fillRect(0,0,500,500)
        socket.onopen = (event:dom.Event) => socket.send("I'm new!")
        socket.onmessage = (event:dom.MessageEvent) => updateDrawvas(event, drawtext)
        var down = false

        // Mouse event functions
        dom.document.onmousedown = (event: dom.MouseEvent) => {
          getMousePosition(event, drawvas)
          down = true
        }
        dom.document.onmouseup = (event:dom.MouseEvent) => {
          down = false
          if (initMousePos.x < 500 && initMousePos.x > 0 && initMousePos.y > 0 && initMousePos.y < 500)
            sendLine(event, drawvas, socket)
        
        }
        dom.document.onmousemove = (event: dom.MouseEvent) => {
          if(down && initMousePos.x < 500 && initMousePos.x > 0 && initMousePos.y > 0 && initMousePos.y < 500) 
              previewLine(event, drawtext, drawvas)
        }
        
        currColor = colorpicker.value
        colorpicker.onchange = (e) => {
          currColor = colorpicker.value
          println(currColor)
          }
      }
    }
  
  ///////////////////// TASK 11 ///////////////////////////
  def getMousePosition(event:dom.MouseEvent, drawvas:html.Canvas) = {
    val xpos = (event.clientX - drawvas.getBoundingClientRect().left).toInt
    val ypos = (event.clientY - drawvas.getBoundingClientRect().top).toInt
    println("Mouse position: (" + xpos + ", " + ypos + ")")
    initMousePos = Point(xpos, ypos)
  }

  def sendLine(event:dom.MouseEvent, drawvas:html.Canvas, socket:dom.WebSocket) = {
    val xpos = (event.clientX - drawvas.getBoundingClientRect().left).toInt
    val ypos = (event.clientY - drawvas.getBoundingClientRect().top).toInt
    println("Mouse position: (" + xpos + ", " + ypos + ")")
    println("Line length: " + math.sqrt(math.pow(xpos, 2) + math.pow(ypos, 2)))
    endMousePos = Point(xpos, ypos)

    val linecsv = initMousePos.x.toString() + "," + initMousePos.y.toString() + "," + xpos.toString() + "," + ypos.toString() + "," + currColor + "," + sizepicker.value
    socket.send(linecsv)
  }

  def updateDrawvas(event:dom.MessageEvent, drawvas:dom.CanvasRenderingContext2D) = {
    val data = event.data.toString()
    drawvas.fillStyle = "white"
    drawvas.fillRect(0, 0, 500, 500)    
    println(data)
  
    if (data.indexOf(';') != -1) {
      
      val lines = data.split(";")
      for (line <- lines) {
        val linedata = line.split(",")
      
        drawvas.beginPath()
        drawvas.strokeStyle = linedata(4)
        drawvas.lineWidth = linedata(5).toDouble

        println(linedata.mkString)
        drawvas.moveTo(linedata(0).toDouble, linedata(1).toDouble)
        drawvas.lineTo(linedata(2).toDouble, linedata(3).toDouble)
      
        drawvas.stroke()
      }
      
    } else if (data.indexOf(',') != -1) {
      val linedata = data.split(",")
      
      drawvas.beginPath()
      drawvas.strokeStyle = linedata(4)
      drawvas.lineWidth = linedata(5).toDouble
            
      drawvas.moveTo(linedata(0).toDouble, linedata(1).toDouble)
      drawvas.lineTo(linedata(2).toDouble, linedata(3).toDouble)

      drawvas.stroke()
    }

  }

  def previewLine(event:dom.MouseEvent, drawvas:dom.CanvasRenderingContext2D, canvas:html.Canvas) = {
    drawvas.fillStyle = "white"
    drawvas.fillRect(0, 0, 500, 500)
    
    drawvas.beginPath()
    drawvas.strokeStyle = colorpicker.value
    drawvas.lineWidth = sizepicker.value.toInt

    drawvas.moveTo(initMousePos.x, initMousePos.y)
    drawvas.lineTo((event.clientX - canvas.getBoundingClientRect().left).toInt, 
        (event.clientY - canvas.getBoundingClientRect().top).toInt)

    drawvas.stroke()

  }

  ///////////////////// TASK 10 ///////////////////////////
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