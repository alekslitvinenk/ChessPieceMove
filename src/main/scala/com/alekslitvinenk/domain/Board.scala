package com.alekslitvinenk.domain

object Board {
  
  val FieldSize = 10
  
  /**
   * List of possible moves on the board
   */
  val moves: List[Direction] = List(N, NE, E, SE, S, SW, W, NW)
  
  /**
   * Check if piece position is withing board
   * @param position - position to verify
   * @return Some(position) if given piece position is withing board and None otherwise
   */
  def verifyPosition(position: Position): Option[Position] =
    if (position.x > 0 &&
        position.x <= FieldSize &&
        position.y > 0 &&
        position.y <= FieldSize) Some(position)
    else None
  
  def size: Int = FieldSize * FieldSize
}
