package com.github.jefersonm.sandbox.scala.learnscala

object PatternMatchingExample {

  def example1(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }
  
  def example2(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
  }
  
  def main(args: Array[String]){
    println(example1(1))
    println(example2("two"))
    
  }
  
}