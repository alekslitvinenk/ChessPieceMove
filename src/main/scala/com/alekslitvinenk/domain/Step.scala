package com.alekslitvinenk.domain

import scala.collection.mutable

/**
 * Step represents current stage of board exploration
 *
 * @param position - current piece position
 * @param visitedTiles - tiles that were already visited, if empty will be substituted with List(position)
 * @param previousStep - step that predeceased the given one
 */
case class Step(position: Position,
                visitedTiles: List[Position] = List.empty,
                previousStep: Option[Step] = None) {
  
  /**
   * List of randomized available moves
   */
  private val availableMoves: mutable.Queue[Direction] = mutable.Queue(SimpleBoard.randomizedMoves: _*)
  
  /**
   * Get next available move
   * @return Some(move) if there still moves available and None otherwise
   */
  def nextMove: Option[Direction] =
    if (availableMoves.isEmpty) None
    else Some(availableMoves.dequeue())
  
  /**
   * Sequence of tiles that were already visited when we reached current step
   */
  val updatedVisitedTiles: List[Position] =
    if (visitedTiles.isEmpty) List(position)
    else visitedTiles
}