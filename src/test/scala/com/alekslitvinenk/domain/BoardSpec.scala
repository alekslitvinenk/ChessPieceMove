package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class BoardSpec extends WordSpec with Matchers {
  
  "Board" should {
    "produce correct size" in {
      val size = Board.size
      
      size should be(100)
    }
  
    "produce Some(position) when position withing board" in {
      val position = Position(1, 1)
      val verifiedPosition = Board.verifyPosition(position)
      
      verifiedPosition should be(Some(Position(1, 1)))
    }
  
    "produce None when position beyond board" in {
      val position = Position(-1, -1)
      val verifiedPosition = Board.verifyPosition(position)
    
      verifiedPosition should be(None)
    }
  }
}
