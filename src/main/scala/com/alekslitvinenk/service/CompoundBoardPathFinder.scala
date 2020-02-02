package com.alekslitvinenk.service

import com.alekslitvinenk.domain.{CompoundBoard, Position, Quarter, Step}

import scala.annotation.tailrec

class CompoundBoardPathFinder(board: CompoundBoard) {
  
  private val quartersRoute: Map[Quarter, List[Quarter]] = Map(
    board.quarterI -> List(board.quarterII, board.quarterIII, board.quarterIV),
    board.quarterII -> List(board.quarterIII, board.quarterIV, board.quarterI),
    board.quarterIII -> List(board.quarterIV, board.quarterI, board.quarterII),
    board.quarterIV -> List(board.quarterI, board.quarterII, board.quarterIII),
  )
  
  /**
   * Run depth-first algorithm to explore th board
   *
   * @return Some(step) when the list of positions spanning across all tiles or None if there's no solution
   */
   def traverseAllTilesDepthFirst(step: Step): List[Position] = {
     val startQuarter = board.getQuarterByPosition(step.position)
     val route = quartersRoute(startQuarter)
  
     val path1 = findRouteWithTransitionQuarterToQuarter(step.position, startQuarter, route(0))
     val path2 = findRouteWithTransitionQuarterToQuarter(path1._1, route(0), route(1))
     val path3 = findRouteWithTransitionQuarterToQuarter(path2._1, route(1), route(2))
     val path4 = SimpleBoardPathFinder(route(2).board).traverseAllTilesDepthFirst(Step(path3._1)).get.updatedVisitedTiles
     
     (path4 ::: path3._2 ::: path2._2 ::: path1._2).reverse
  }
  
  @tailrec
  private def findRouteWithTransitionQuarterToQuarter(position: Position, from: Quarter, to: Quarter): (Position, List[Position]) = {
    val simpleBoardPathFinder = SimpleBoardPathFinder(from.board)
    
    val firstStep = from.board.verifyPosition(position)
      .map(Step(_))
      .getOrElse(throw new RuntimeException(s"Given $position doesn't belong to $from quarter"))
    
    val finalStep = simpleBoardPathFinder.traverseAllTilesDepthFirst(firstStep)
      .getOrElse(throw new RuntimeException(s"Path to traverse $from quarter was not found"))
    
    val transitionPositionOpt = finalStep.explode().find(p => to.board.allTiles.contains(p))
    if (transitionPositionOpt.isDefined) (transitionPositionOpt.get, finalStep.updatedVisitedTiles)
    else findRouteWithTransitionQuarterToQuarter(position = position, from = from, to = to)
  }
}

object CompoundBoardPathFinder {
  def apply(board: CompoundBoard): CompoundBoardPathFinder = new CompoundBoardPathFinder(board)
}
