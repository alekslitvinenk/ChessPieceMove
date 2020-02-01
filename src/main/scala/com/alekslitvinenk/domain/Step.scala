package com.alekslitvinenk.domain

import scala.annotation.tailrec
import scala.collection.mutable
import scala.util.Random

/**
 * Step represents current stage of board exploration
 *
 * @param position - current piece position
 * @param visitedTiles - tiles that were already visited, if empty will be substituted with List(position)
 */
case class Step(position: Position,
                visitedTiles: List[Position] = List.empty,
                availableMoves: mutable.Queue[Direction] = mutable.Queue(Random.shuffle(Board.moves): _*),
                previousStep: Option[Step] = None) {
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
  def explode(): List[Step] = Board.moves.flatMap(_.go(position)).flatMap { p =>
    if (updatedVisitedTiles.contains(p)) None
    else Some(Step(p, p :: updatedVisitedTiles))
  }
  
  /**
   * Run depth-first algorithm to explore th board, pick the first
   * next step in the list when few opportunities present
   *
   * @return Some(step) when the next move possible and None otherwise
   */
  def findPath(): Option[Step] = {
    loop(this)
  }
  
  @tailrec
  private def loop(step: Step): Option[Step] = {
    //println(step)
    if (step.updatedVisitedTiles.size == Board.size) {
      Some(step)
    } else {
      if (step.availableMoves.isEmpty) {
        if (step.previousStep.isEmpty) Option.empty[Step]
        else {
          //println(s"Returning to previous step $step")
          loop(step.previousStep.get)
        }
      } else {
        val nextMove = step.availableMoves.dequeue()
        val nextPositionOpt = nextMove.go(step.position)
        
        if (nextPositionOpt.isEmpty) {
          loop(step)
        } else {
          val nextPosition = nextPositionOpt.get
          if (step.updatedVisitedTiles.contains(nextPosition)) {
            loop(step)
          } else {
            loop(Step(nextPosition, nextPosition :: step.updatedVisitedTiles, mutable.Queue(Random.shuffle(Board.moves): _*), Some(step)))
          }
        }
      }
    }
  }
}
