package com.alekslitvinenk

import com.alekslitvinenk.domain.{SimpleBoard, Position, Step}
import com.alekslitvinenk.service.SimpleBoardPathFinder

object Main extends App {
  val pathFinder = SimpleBoardPathFinder(SimpleBoard(5))
  
  val startPosition = Step(Position(3, 3))
  
  val startTime = System.currentTimeMillis()
  val rez = pathFinder.traverseAllTilesDepthFirst(startPosition)
  println(s"Time: ${System.currentTimeMillis() - startTime}ms")
  
  println(rez)
}
