package com.alekslitvinenk.domain

sealed trait Quarter {
  val board: SimpleBoard
}

case class QuarterI(board: SimpleBoard) extends Quarter
case class QuarterII(board: SimpleBoard) extends Quarter
case class QuarterIII(board: SimpleBoard) extends Quarter
case class QuarterIV(board: SimpleBoard) extends Quarter
