package com.alekslitvinenk.service

import com.alekslitvinenk.domain.{SimpleBoard, Step}

import scala.annotation.tailrec

class PathFinder(board: SimpleBoard) {
  /**
   * Run depth-first algorithm to explore th board, pick the first
   * next step in the list when few opportunities present
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

object PathFinder {
  def apply(board: SimpleBoard): PathFinder = new PathFinder(board)
}
