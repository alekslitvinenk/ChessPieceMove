package com.alekslitvinenk.service

import com.alekslitvinenk.domain.{Position, SimpleBoard, Step}
import org.scalatest.{Matchers, WordSpec}

class SimpleBoardPathFinderSpec extends WordSpec with Matchers {
  "SimpleBoardPathFinderSpec" should {
    "produce path that covers all tiles on the board(5x5)" in {
      val board = SimpleBoard(5)
      val startStep = Step(Position(1, 1))
      val service = SimpleBoardPathFinder(board)
      val path = service.traverseAllTilesDepthFirst(startStep).get
      val visitedTiles = path.visitedTiles
      val allTiles = board.allTiles
      
      visitedTiles.length should be(25)
      
      for {
        i <- 0 until 25
      } yield visitedTiles.contains(allTiles(i))
    }
  }
}
