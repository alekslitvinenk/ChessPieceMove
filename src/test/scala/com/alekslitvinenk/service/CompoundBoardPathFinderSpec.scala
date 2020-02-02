package com.alekslitvinenk.service

import com.alekslitvinenk.domain.{CompoundBoard, Position, Step}
import org.scalatest.{Matchers, WordSpec}

class CompoundBoardPathFinderSpec extends WordSpec with Matchers {
  "CompoundBoardPathFinderSpec" should {
    "produce path that covers all tiles on the board(10x10)" in {
      val board = CompoundBoard(5)
      val startStep = Step(Position(1, 1))
      val service = CompoundBoardPathFinder(board)
      val path = service.traverseAllTilesDepthFirst(startStep)
  
      path.length should be(100)
      
      for {
        i <- 0 until 100
      } yield path.contains(board.allTiles(i)) should be(true)
    }
  }
}
