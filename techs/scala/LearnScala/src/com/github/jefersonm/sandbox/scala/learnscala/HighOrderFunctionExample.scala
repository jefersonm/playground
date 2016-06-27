package com.github.jefersonm.sandbox.scala.learnscala

object HighOrderFunctionExample {

	def onePerSecond(callback: () => Unit){
		while (true) {callback(); Thread sleep 1000}
	}

	def timeFlies(){
		println("time flies like an arrow...")
	}

	def main(args: Array[String]){
		onePerSecond(timeFlies)
	}

}