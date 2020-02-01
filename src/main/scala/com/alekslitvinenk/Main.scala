package com.alekslitvinenk

import com.alekslitvinenk.domain.{Board, Position, Step}
import com.alekslitvinenk.service.PathFinder

object Main extends App {
  val pathFinder = PathFinder(Board(5))
  
  val step = Step(Position(1, 1))
  val rez = pathFinder.traverseAllTilesDepthFirst(step)
  
  println(rez)
}
