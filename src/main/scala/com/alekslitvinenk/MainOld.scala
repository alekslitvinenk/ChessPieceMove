package com.alekslitvinenk

import com.alekslitvinenk.domain.{CompoundBoard, Position, Step}
import com.alekslitvinenk.service.CompoundBoardPathFinder

object MainOld extends App {
  val pathFinder = CompoundBoardPathFinder(CompoundBoard(5))
  
  val startPosition = Step(Position(7, 3))
  
  val startTime = System.currentTimeMillis()
  val rez = pathFinder.traverseAllTilesDepthFirst(startPosition)
  println(s"Time: ${System.currentTimeMillis() - startTime}ms")
  println(rez.size)
  
  println(rez)
}
