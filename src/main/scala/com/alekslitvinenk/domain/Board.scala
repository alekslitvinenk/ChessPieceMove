package com.alekslitvinenk.domain

import scala.util.Random

/**
 * Chess board abstraction
 * @param size
 */
case class Board(size: Int) {
  
  /**
   * Total tiles count on the given board
   */
  val tilesCount: Int = size * size
  
  /**
   * Moves a chess piece at given `from` position to a new position in specified `direction`
   * @param from position to move from
   * @param direction direction in which to move
   * @return Some(position) if given piece position is withing board and None otherwise
   */
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
  
  /**
   * Get randomized list of moves. Useful if heuristic algorithms
   * @return
   */
  def randomizedMoves: List[Direction] = Random.shuffle(allMoves)
  
  /**
   * List of moves in clock wise direction starting from N(North)
   */
  val moves: List[Direction] = allMoves
}
