package com.github.jefersonm.sandbox.scala.learnscala

object BasicPatternMatchingExample {

  def example1(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }

  def example2(x: Int) = x match {
    case 1 | 2 | 3 => "one, two or three"
    case 4 => 4
    case whatever => "some other number"
  }
  
  def example3(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
  }
  
  def main(args: Array[String]){
    println(example1(1))
    println(example2(4))
    println(example3("two"))
  }
  
}