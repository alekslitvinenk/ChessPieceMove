package com.alekslitvinenk.domain

trait Board {
  
  def allTiles(): List[Position]
  def tilesCount: Int
}
