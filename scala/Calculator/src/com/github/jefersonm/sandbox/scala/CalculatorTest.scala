package com.github.jefersonm.sandbox.scala
import junit.framework.TestCase
import junit.framework.Assert._
import com.github.jefersonm.sandbox.scala.Calculator._


class CalculatorTest extends TestCase {

  def testSum() = assertEquals(2, calc(1,1,"+"));
  def testSub() = assertEquals(3, calc(4,1,"-"));
  def testMul() = assertEquals(8, calc(4,2,"*"));
  def testDiv() = assertEquals(6, calc(12,2,"/"));
  def testUnsupportedOperation() = assertEquals("This operation isn't supported", calc(12,2,"%"));
  
}