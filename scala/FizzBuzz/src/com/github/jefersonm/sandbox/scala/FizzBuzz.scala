package com.github.jefersonm.sandbox.scala

object FizzBuzz {

  def processArray(nums: Array[Int]): String = {
	var result = ""
	  for(num <- nums) {
	    if(num % 3 == 0 && num % 5 == 0) result += "fizzbuzz,"
	    else if(num % 3 == 0) result += "fizz,"
	    else if(num % 5 == 0) result += "buzz,"
	    else result += num + ","
	  }
	result.dropRight(1)
  }
  
}