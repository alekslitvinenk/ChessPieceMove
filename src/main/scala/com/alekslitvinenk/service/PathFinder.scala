package com.alekslitvinenk.service

import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

import com.alekslitvinenk.domain.{Board, Position, Step}

import scala.concurrent.{ExecutionContext, Future}

class PathFinder {
  
  private val threadPool = Executors.newFixedThreadPool(35)
  private implicit val ecFixed = ExecutionContext.fromExecutor(threadPool)
  private val loopCounter = new AtomicInteger(0)
  
  def traverseAllTilesBreadthFirst(from: Position): Future[List[Step]] = {
    
    def loop(ls: List[Step]): Future[List[Step]] = {
      println(s"Step: ${loopCounter.incrementAndGet()}")
      if (ls.isEmpty || ls.par.exists(checkAllTilesTraversed)) Future.successful(ls)
      else Future.reduceLeft(ls.map(futureExplode))(_ ++ _).flatMap(loop)
    }
  
    def futureExplode(step: Step) = Future { step.explode() }
    
    val initialStep: List[Step] = Board.verifyPosition(from).map(Step(_)).toList
    loop(initialStep)
  }
  
  def traverseAllTilesDepthFirst(from: Position): Future[Option[Step]] = ???
  
  private def checkAllTilesTraversed(step: Step): Boolean =
    step.updatedVisitedTiles.size == Board.size
}

object PathFinder {
  def apply(): PathFinder = new PathFinder()
}
