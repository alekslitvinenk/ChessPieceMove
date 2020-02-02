package com.alekslitvinenk.service

import com.alekslitvinenk.domain.{SimpleBoard, Step}

import scala.annotation.tailrec

class SimpleBoardPathFinder(board: SimpleBoard) {
  /**
   * Run depth-first algorithm to explore th board
   *
   * @return Some(step) when the list of positions spanning across all tiles or None if there's no solution
   */
  @tailrec
  final def traverseAllTilesDepthFirst(step: Step): Option[Step] = {
    //println(step)
    if (step.updatedVisitedTiles.size == board.tilesCount) {
      Some(step)
    } else {
      val nextMoveOpt = step.nextMove
      if (nextMoveOpt.isEmpty) {
        if (step.previousStep.isEmpty) Option.empty[Step]
        else {
          //println(s"Returning to previous step $step")
          traverseAllTilesDepthFirst(step.previousStep.get)
        }
      } else {
        val direction = nextMoveOpt.get
        val nextPositionOpt = board.move(from = step.position, direction = direction)
        
        if (nextPositionOpt.isEmpty) {
          traverseAllTilesDepthFirst(step)
        } else {
          val nextPosition = nextPositionOpt.get
          if (step.updatedVisitedTiles.contains(nextPosition)) {
            traverseAllTilesDepthFirst(step)
          } else {
            traverseAllTilesDepthFirst(Step(nextPosition, nextPosition :: step.updatedVisitedTiles, Some(step)))
          }
        }
      }
    }
  }
}

object SimpleBoardPathFinder {
  def apply(board: SimpleBoard): SimpleBoardPathFinder = new SimpleBoardPathFinder(board)
}
