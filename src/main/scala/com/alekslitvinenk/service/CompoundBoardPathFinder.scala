package com.alekslitvinenk.service

import com.alekslitvinenk.domain.{CompoundBoard, Step}

class CompoundBoardPathFinder(board: CompoundBoard) extends PathFinder {
  /**
   * Run depth-first algorithm to explore th board
   *
   * @return Some(step) when the list of positions spanning across all tiles or None if there's no solution
   */
  override def traverseAllTilesDepthFirst(step: Step): Option[Step] = ???
}

object CompoundBoardPathFinder {
  def apply(board: CompoundBoard): CompoundBoardPathFinder = new CompoundBoardPathFinder(board)
}
