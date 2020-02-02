package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class StepSpec extends WordSpec with Matchers {

  "Step" should {
    "produce correct sequence of steps when initial position is (5, 5)" in {
      val step = Step(Position(5, 5))
      val positions = step.explode()
    
      positions should be(List(
        Position(5, 2), Position(7, 3), Position(8, 5), Position(7, 7),
        Position(5, 8), Position(3, 7), Position(2, 5), Position(3, 3))
      )
    }
  }
}
