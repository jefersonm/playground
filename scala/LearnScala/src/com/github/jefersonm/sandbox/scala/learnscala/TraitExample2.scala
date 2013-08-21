package com.github.jefersonm.sandbox.scala.learnscala

trait Similarity {
  
  def isSimilar(x: Any): Boolean
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  
}

class Point(xc: Int, yc: Int) extends Similarity {
  
  var x: Int = xc
  var y: Int = yc
  
  def isSimilar(obj: Any) = 
    obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == x
  
}

//Extend Applicaton then it doesn't need to implement a main method
object TraitTest extends Application {
  
  val p1 = new Point(2,3)
  val p2 = new Point(2,4)
  val p3 = new Point(3,4)
  println(p1.isNotSimilar(p2))
  println(p1.isSimilar(p3))
  println(p1.isNotSimilar(2))
  
}