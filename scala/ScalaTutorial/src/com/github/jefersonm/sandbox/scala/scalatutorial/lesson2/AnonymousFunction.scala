package com.github.jefersonm.sandbox.scala.scalatutorial.lesson2

object AnonymousFunction {

	//receive a function as parameter. The function type is Unit, it's similar to void in Java
	def oncePerSecond(callback: () => Unit){
		while(true) { callback(); Thread sleep 1000 }
	}
	
	//I'm creating an anonymous function and passing it as parameter of oncePerSecond function.
	//the right arrow '=>' separates the function's argument list from its body.
	def main(args: Array[String]) {
		oncePerSecond(() =>
		  println("time flies like an arrow..."))
	}

}