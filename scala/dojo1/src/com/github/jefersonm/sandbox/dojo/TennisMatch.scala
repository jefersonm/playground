package com.github.jefersonm.sandbox.dojo

class TennisMatch {

  var scoreA = 0
  var scoreB = 0;
  var game = 0
  var sets = 0

  def getSets() = sets

  def getGame() = game

  def getScore(scoreA:Int, scoreB:Int) = (scoreA, scoreB) match {
    case (0 , 0) => "0 X 0"
    case (40 ,40) => "DEUCE"  
    case _ => ""
  }

  def resetScore() {
    scoreA = 0
    scoreB = 0
  }
  
  def increaseScoreA() = scoreA  match{
    case 0 => scoreA = 15
    case 15 => scoreA = 30
    case 30 => scoreA = 40
    case 40 => resetScore()
  }
  

}