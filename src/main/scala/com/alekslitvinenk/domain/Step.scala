package com.alekslitvinenk.domain

/**
 * Step represents current stage of board exploration
 *
 * @param position - current piece position
 * @param visitedTiles - tiles that were already visited, if empty will be substituted with List(position)
 */
case class Step(position: Position, visitedTiles: List[Position] = List.empty) {
  
  /**
   * List of possible moves on the board
   */
  private val moves: List[Direction] = List(N, NE, E, SE, S, SW, W, NW)
  
  /**
   * Sequence of tiles that were already visited when we reached current step
   */
  val updatedVisitedTiles: List[Position] =
    if (visitedTiles.isEmpty) List(position)
    else visitedTiles
  
  /**
   * Run breadth-first algorithm to explore the board
   *
   * @return list of new steps which stem from the current
   */
  def explode(): List[Step] = moves.flatMap(_.go(position)).flatMap { p =>
    if (updatedVisitedTiles.contains(p)) None
    else Some(Step(p, p :: updatedVisitedTiles))
  }
  
  /**
   * Run depth-first algorithm to explore th board, pick the first
   * next step in the list when few opportunities present
   *
   * @return Some(step) when the next move possible and None otherwise
   */
  def chooseNext(): Option[Step] = ???
}
