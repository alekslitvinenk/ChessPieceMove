package com.alekslitvinenk.domain

case class CompoundBoard(componentSize: Int = 5) extends Board {
  
  val quarterI:   Quarter = QuarterI(SimpleBoard(componentSize, Position(1, 1)))
  val quarterII:  Quarter = QuarterII(SimpleBoard(componentSize, Position(6, 1)))
  val quarterIII: Quarter = QuarterIII(SimpleBoard(componentSize, Position(6, 6)))
  val quarterIV:  Quarter = QuarterIV(SimpleBoard(componentSize, Position(1, 6)))
  
  val allQuarters: List[Quarter] = List(quarterI, quarterII, quarterIII, quarterIV)
  
  val allTiles: List[Position] = allQuarters.map(_.board).flatMap(_.allTiles)
  val tilesCount: Int = allTiles.size
  
  def getQuarterByPosition(position: Position): Quarter = allQuarters.find { quarter =>
    quarter.board.allTiles.contains(position)
  }.getOrElse(throw new RuntimeException("Quarter that hold given position not found"))
}
