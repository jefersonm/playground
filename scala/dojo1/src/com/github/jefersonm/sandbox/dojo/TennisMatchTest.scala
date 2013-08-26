package com.github.jefersonm.sandbox.dojo

import org.junit.Test
import junit.framework.Assert._

class TennisMatchTest {
  
  var e: TennisMatch = new TennisMatch

  @Test def testScore = assertEquals(e getScore(0, 0), 0 + " X " + 0)
  
  @Test
  def testResetScore {
    e.resetScore()
    assertEquals(e.scoreA, 0)
    assertEquals(e scoreB, 0)
  }
  
  @Test def testGetGame = assertEquals(e.getGame(), 0)
  
  @Test def testGetSets = assertEquals(e.getSets, 0)
  
  @Test def testDeuce =  assertEquals(e getScore(40,40) , "DEUCE")
  
  @Test def increaseScore {
    e.increaseScoreA
    assertEquals(15 , e.scoreA)
  }
  
  @Test def increase2TimesScore {
    e.increaseScoreA
    e.increaseScoreA
    assertEquals(30, e.scoreA)
  }
  
  @Test def testDulce {
    e.scoreB = 40
    e.increaseScoreA
    e.increaseScoreA
    e.increaseScoreA
    assertEquals(40, e.scoreA)
  }
}