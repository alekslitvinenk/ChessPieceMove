package com.alekslitvinenk.domain

import scala.collection.mutable

/**
 * Step represents current stage of board exploration
 *
 * @param position - current piece position
 * @param visitedTiles - tiles that were already visited, if empty will be substituted with List(position)
 */
case class Step(position: Position,
                visitedTiles: List[Position] = List.empty,
                availableMoves: mutable.Queue[Direction] = mutable.Queue(Board.moves: _*),
                previousStep: Option[Step] = None) {
  /**
   * Sequence of tiles that were already visited when we reached current step
   */
  val updatedVisitedTiles: List[Position] =
    if (visitedTiles.isEmpty) List(position)
    else visitedTiles
}
