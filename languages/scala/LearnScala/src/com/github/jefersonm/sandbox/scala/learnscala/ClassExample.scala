package com.github.jefersonm.sandbox.scala.learnscala

class ClassExample(real: Double, imaginary: Double) {

	def re = real
	def im() = imaginary

	//To override a method is mandatory to add override string before the method
	override def toString = 
	  "" + re + " " + im
	
}

object TestClass{
  
	def main(args: Array[String]){
		val ex = new ClassExample(1.0, 2.0)
		println(ex re)
		println(ex im)
		println((ex im) + (ex re))
		
		println("Imaginary part: " + ex.im)
	}
	
}