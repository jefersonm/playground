package com.github.jefersonm.sandbox.scala.learnscala

trait Ord {

  def < (that: Any): Boolean
  def <=(that: Any): Boolean =  (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
  
}

class ProcessDate(y: Int, m: Int, d: Int) extends Ord {
  
  def year = y
  def month = m
  def day = d
  override def toString(): String = year + "-" + month + "-" + day
  
  override def equals(that: Any): Boolean =
  	that.isInstanceOf[ProcessDate] && {
	    val o = that.asInstanceOf[ProcessDate]
	    o.day == day && o.month == month && o.year == year
  	}
  
  def <(that: Any): Boolean = {
	  if (!that.isInstanceOf[ProcessDate])
	    error("cannot compare " + that + " and a Date")
	  val o = that.asInstanceOf[ProcessDate]
	  (year < o.year) ||
	  (year == o.year && (month < o.month || (month == o.month && day < o.day)))
  }
  
}