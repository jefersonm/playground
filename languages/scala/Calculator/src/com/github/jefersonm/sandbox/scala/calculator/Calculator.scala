package com.github.jefersonm.sandbox.scala.calculator

object Calculator {

  def calc(val1:Int, val2:Int, arg:Any): Any = arg match {
    case "+" => val1 + val2
    case "-" => val1 - val2
    case "*" => val1 * val2
    case "/" => val1 / val2
    case  _  => "This operation isn't supported"
  }
  
}