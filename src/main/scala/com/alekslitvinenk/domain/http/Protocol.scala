package com.alekslitvinenk.domain.http

object Protocol {
  
  final case class Pos(x: Int, y: Int)
  
  final case class PathResponse(
    items: List[Pos]
  )
}
