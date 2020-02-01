package com.alekslitvinenk.domain

case class CompoundBoard(componentSize: Int = 5) {
  
  val firstQuarter:  SimpleBoard = SimpleBoard(componentSize, Position(1, 1))
  val secondQuarter: SimpleBoard = SimpleBoard(componentSize, Position(6, 1))
  val thirdQuarter:  SimpleBoard = SimpleBoard(componentSize, Position(6, 6))
  val forthQuarter:  SimpleBoard = SimpleBoard(componentSize, Position(1, 6))
}
