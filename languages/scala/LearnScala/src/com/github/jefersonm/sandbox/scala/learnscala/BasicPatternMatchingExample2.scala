package com.github.jefersonm.sandbox.scala.learnscala

object BasicPatternMatchingExample2 {

  def factNormal(n: Int): Int =
    if (n == 0) 1
    else n * factNormal(n - 1)

  def factSmart(n: Int): Int = n match {
    case 0 => 1
    case n => n * factSmart(n - 1)
  }

  def main(args: Array[String]){
    println(factNormal(4))
    println(factNormal(0))
    println(factSmart(4))
    println(factSmart(0))
  }

}
