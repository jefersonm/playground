package com.github.jefersonm.sandbox.scala
import junit.framework.TestCase
import junit.framework.Assert._
import com.github.jefersonm.sandbox.scala.FizzBuzz._


class FizzBuzzTest extends TestCase {

  def testFizz() = assertEquals("fizz", processArray(Array(3)));
  def testBuzz() = assertEquals("buzz", processArray(Array(5)));
  def testFizzBuzz() = assertEquals("fizzbuzz", processArray(Array(15)));
  def test10Numbers() = assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", 
      processArray(Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)))
  
}