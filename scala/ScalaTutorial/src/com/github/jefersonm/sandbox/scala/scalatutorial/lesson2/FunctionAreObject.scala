package com.github.jefersonm.sandbox.scala.scalatutorial.lesson2

object FunctionAreObject {

	//receive a function as parameter. The function type is Unit, it's similar to void in Java
	def oncePerSecond(callback: () => Unit){
		while(true) { callback(); Thread sleep 1000 }
	}

	def timeFlies(){
		println("time flies like an arrow...")
	}

	def main(args: Array[String]) {
		oncePerSecond(timeFlies)
	}

}