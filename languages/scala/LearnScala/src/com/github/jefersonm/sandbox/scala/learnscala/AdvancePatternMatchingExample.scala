package com.github.jefersonm.sandbox.scala.learnscala

class Expression {

  case class X() extends Expression
  case class Const(value: Int) extends Expression
  case class Add(left: Expression, right: Expression) extends Expression
  case class Mult(left: Expression, right: Expression) extends Expression
  case class Neg(expr: Expression) extends Expression

  def eval(expression: Expression, xValue: Int): Int = expression match {
    case X() => xValue
    case Const(cst) => cst
    case Add(left, right) => eval(left, xValue) + eval(right, xValue)
    case Mult(left, right) => eval(left, xValue) + eval(right, xValue)
    case Neg(expr) => - eval(expr, xValue)
  }



}

object ExpressionTest extends Expression {

  def main(args: Array[String]){
    //val expr = Add(Const(1), Mult(Const(2), Mult(X(), X()))) // 1 + 2 * X*X
    val expr = Add(Const(1), Mult(Const(2), Mult(X(), X())))  // 1 + 2 * X*X
    assert(eval(expr, 3) == 19)
    //assert(eval(expr, 3) == 19)
    println(eval(expr, 3))

  }

}