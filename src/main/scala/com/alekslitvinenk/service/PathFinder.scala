package com.alekslitvinenk.service

import java.util.concurrent.Executors

import com.alekslitvinenk.domain.{Board, Position, Step}

import scala.annotation.tailrec
import scala.concurrent.{ExecutionContext, Future}

class PathFinder {
  
  val threadPool = Executors.newFixedThreadPool(35)
  implicit val ecFixed = ExecutionContext.fromExecutor(threadPool)
  
  def traverseAllTilesBreadthFirst(from: Position): Future[List[Step]] = {
    
    def loop(ls: List[Step]): Future[List[Step]] =
      if (ls.isEmpty || ls.par.exists(checkAllTilesTraversed)) Future.successful(ls)
      else Future { ls.flatMap(_.explode()) }.flatMap(loop)
    
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
