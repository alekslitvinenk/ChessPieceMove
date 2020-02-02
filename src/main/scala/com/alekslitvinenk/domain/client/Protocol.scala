package com.alekslitvinenk.domain.client

object Protocol {
  
  final case class Pos(x: Int, y: Int)
  
  final case class PathResponse(
    items: List[Pos]
  )
}
