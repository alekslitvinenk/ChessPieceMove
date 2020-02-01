package com.alekslitvinenk.service

import com.alekslitvinenk.domain.Step

trait PathFinder {
  
  /**
   * Run depth-first algorithm to explore th board
   *
   * @return Some(step) when the list of positions spanning across all tiles or None if there's no solution
   */
  def traverseAllTilesDepthFirst(step: Step): Option[Step]
}
