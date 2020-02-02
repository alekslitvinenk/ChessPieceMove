package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class CompoundBoardSpec extends WordSpec with Matchers {
  
  "CompoundBoard" should {
    "produce correct tilesCount when board size is 10x10 when tilesCount called" in {
      val board = CompoundBoard(5)
  
      board.tilesCount should be(100)
    }
    
    "produce list of positions covering all board when allTiles called" in {
      val board = CompoundBoard(5)
      val allTiles = board.allTiles
      
      allTiles.size should be(100)
      
      for {
        i <- 1 to 10
        j <- 1 to 10
      } yield allTiles.contains(Position(i, j)) should be(true)
    }
    
    "return quarterI for given position when getQuarterByPosition called" in {
      val board = CompoundBoard(5)
      val position = Position(1, 1)
      
      board.getQuarterByPosition(position) should be(board.quarterI)
    }
  
    "return quarterII for given position when getQuarterByPosition called" in {
      val board = CompoundBoard(5)
      val position = Position(7, 5)
    
      board.getQuarterByPosition(position) should be(board.quarterII)
    }
  
    "return quarterIII for given position when getQuarterByPosition called" in {
      val board = CompoundBoard(5)
      val position = Position(7, 8)
    
      board.getQuarterByPosition(position) should be(board.quarterIII)
    }
  
    "return quarterVI for given position when getQuarterByPosition called" in {
      val board = CompoundBoard(5)
      val position = Position(3, 8)
    
      board.getQuarterByPosition(position) should be(board.quarterIV)
    }
  }
}
