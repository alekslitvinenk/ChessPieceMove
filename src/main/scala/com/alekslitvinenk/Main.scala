package com.alekslitvinenk

import com.alekslitvinenk.domain.{Board, Position, Step}
import com.alekslitvinenk.service.PathFinder

object Main extends App {
  val pathFinder = PathFinder(Board(5))
  
  val startPosition = Step(Position(3, 3))
  
  val startTime = System.currentTimeMillis()
  val rez = pathFinder.traverseAllTilesDepthFirst(startPosition)
  println(s"Time: ${System.currentTimeMillis() - startTime}")
  
  println(rez)
}
