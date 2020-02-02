package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class CompoundBoardSpec extends WordSpec with Matchers {
  
  "CompoundBoard" should {
    "produce correct tilesCount when board size is 10x10" in {
      val board = CompoundBoard(5)
  
      board.tilesCount should be(100)
    }
  }
}
