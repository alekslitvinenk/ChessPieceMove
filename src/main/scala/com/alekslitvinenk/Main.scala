package com.alekslitvinenk

import com.alekslitvinenk.domain.{CompoundBoard, Position, Step}
import com.alekslitvinenk.service.CompoundBoardPathFinder

object Main extends App {
  val pathFinder = CompoundBoardPathFinder(CompoundBoard(5))
  
  val startPosition = Step(Position(3, 3))
  
  val startTime = System.currentTimeMillis()
  val rez = pathFinder.traverseAllTilesDepthFirst(startPosition)
  println(s"Time: ${System.currentTimeMillis() - startTime}ms")
  
  println(rez)
}
