package com.alekslitvinenk

import com.alekslitvinenk.domain.Position
import com.alekslitvinenk.service.PathFinder

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {
  val pathFinder = PathFinder()
  
  val f = pathFinder.traverseAllTilesBreadthFirst(Position(1, 1))
  
  val rez = Await.result(f, Duration.Inf)
  
  println(rez)
}
