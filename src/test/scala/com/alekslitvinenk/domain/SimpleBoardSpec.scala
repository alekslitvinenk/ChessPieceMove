package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class SimpleBoardSpec extends WordSpec with Matchers {
  
  "Board" should {
    "produce correct tilesCont when board size is 5" in {
      val board = SimpleBoard(5)
      
      board.tilesCount should be(25)
    }
  
    "produce correct tilesCont when board size is 10" in {
      val board = SimpleBoard(10)
    
      board.tilesCount should be(100)
    }
  
    "produce Some(position) when verifying position withing board(5x5)" in {
      val board = SimpleBoard(5)
      val position = Position(1, 1)
      val verifiedPosition = board.verifyPosition(position)
      
      verifiedPosition should be(Some(Position(1, 1)))
    }
  
    "produce None when verifying position beyond board(5x5)" in {
      val board = SimpleBoard(5)
      val position = Position(-1, -1)
      val verifiedPosition = board.verifyPosition(position)
    
      verifiedPosition should be(None)
    }
  }
}
