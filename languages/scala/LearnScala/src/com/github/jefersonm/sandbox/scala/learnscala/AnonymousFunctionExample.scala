package com.github.jefersonm.sandbox.scala.learnscala

object AnonymousFunctionExample {

	def onePerSecond(callback: () => Unit){
		while (true) {callback(); Thread sleep 1000}
	}

	def main(args: Array[String]){
		onePerSecond(() => 
		  println("time flies like an arrow..."))
	}

}