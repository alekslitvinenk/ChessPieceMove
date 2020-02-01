package com.alekslitvinenk.domain

/**
 * Way for a piece to go, has 8 possible subclasses
 * N  - North
 * NE - North East
 * E  - East
 * SE - South East
 * S  - South
 * SW - South West
 * W  - West
 * NW - North West
 */
sealed trait Direction {
  
  /**
   * Transform given position to a new position denoted by subclass
   * @param position - position to transform
   * @return new position
   * lies within board, otherwise - None
   */
  def go(position: Position): Position
}

case object N extends Direction {
  override def go(position: Position): Position = Position(position.x, position.y - 3)
}

case object NE extends Direction {
  override def go(position: Position): Position = Position(position.x + 2, position.y - 2)
}

case object E extends Direction {
  override def go(position: Position): Position = Position(position.x + 3, position.y)
}

case object SE extends Direction {
  override def go(position: Position): Position = Position(position.x + 2, position.y + 2)
}

case object S extends Direction {
  override def go(position: Position): Position = Position(position.x, position.y + 3)
}

case object SW extends Direction {
  override def go(position: Position): Position = Position(position.x - 2, position.y + 2)
}

case object W extends Direction {
  override def go(position: Position): Position = Position(position.x - 3, position.y)
}

case object NW extends Direction {
  override def go(position: Position): Position = Position(position.x - 2, position.y - 2)
}
