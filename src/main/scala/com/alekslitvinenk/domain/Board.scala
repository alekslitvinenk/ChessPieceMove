package com.alekslitvinenk.domain

import scala.util.Random

case class Board(size: Int) {
  
  /**
   * Total tiles count on the given board
   */
  val tilesCount: Int = size * size
  
  def move(from: Position, direction: Direction): Option[Position] = verifyPosition(direction.go(from))
  
  /**
   * Check if piece position is withing board
   * @param position - position to verify
   * @return Some(position) if given piece position is withing board and None otherwise
   */
  def verifyPosition(position: Position): Option[Position] =
    if (position.x > 0 &&
        position.x <= size &&
        position.y > 0 &&
        position.y <= size) Some(position)
    else None
}

object Board {
  
  /**
   * List of possible moves on the board
   */
  private val allMoves: List[Direction] = List(N, NE, E, SE, S, SW, W, NW)
  
  def moves(randomize: Boolean = false): List[Direction] =
    if (randomize) Random.shuffle(allMoves)
    else allMoves
  
  val moves: List[Direction] = allMoves
}
