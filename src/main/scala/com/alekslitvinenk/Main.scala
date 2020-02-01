package com.alekslitvinenk

import com.alekslitvinenk.domain.{Position, Step}
import com.alekslitvinenk.service.PathFinder

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {
  val pathFinder = PathFinder()
  
  //val f = pathFinder.traverseAllTilesBreadthFirst(Position(1, 1))
  
 val rez = Step(Position(1, 1)).findPath()
  
  println(rez)
}
