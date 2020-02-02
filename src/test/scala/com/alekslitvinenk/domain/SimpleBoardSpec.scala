package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class SimpleBoardSpec extends WordSpec with Matchers {
  
  "SimpleBoard" should {
    "produce correct tilesCount when board size is 5" in {
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
  
    "produce correct list of positions when calling allTiles for board(2x2)" in {
      val board = SimpleBoard(2)
    
      board.allTiles should be(List(Position(1,1), Position(1,2), Position(2,1), Position(2,2)))
    }
  }
}
