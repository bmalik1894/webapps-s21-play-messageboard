package edu.trinity.videoquizreact.shared

object SharedMessages {
  def itWorks = "It works!"
}
trait Shape
case class Point(var x:Double, var y:Double) extends Shape
case class Line(start:Point, end:Point, color:String, size:String) extends Shape
