package com.alekslitvinenk.domain

import org.scalatest.{Matchers, WordSpec}

class StepSpec extends WordSpec with Matchers {

  "Step" should {
    "produce correct sequence of steps when initial position is (1,1)" in {
      val step = Step(Position(1, 1))
      val steps = step.explode()
      val positions = steps.map(_.position)
      
      positions should be(List(Position(4, 1), Position(3, 3), Position(1, 4)))
    }
  
    "produce correct sequence of steps when initial position is (10,10)" in {
      val step = Step(Position(10, 10))
      val steps = step.explode()
      val positions = steps.map(_.position)
    
      positions should be(List(Position(10, 7), Position(7, 10), Position(8, 8)))
    }
  
    "produce correct sequence of steps when initial position is (10,1)" in {
      val step = Step(Position(10, 1))
      val steps = step.explode()
      val positions = steps.map(_.position)
    
      positions should be(List(Position(10, 4), Position(8, 3), Position(7, 1)))
    }
  
    "produce correct sequence of steps when initial position is (1, 10)" in {
      val step = Step(Position(1, 10))
      val steps = step.explode()
      val positions = steps.map(_.position)
    
      positions should be(List(Position(1, 7), Position(3, 8), Position(4, 10)))
    }
  
    "produce correct sequence of steps when initial position is (5, 5)" in {
      val step = Step(Position(5, 5))
      val steps = step.explode()
      val positions = steps.map(_.position)
    
      positions should be(List(
        Position(5, 2), Position(7, 3), Position(8, 5), Position(7, 7),
        Position(5, 8), Position(3, 7), Position(2, 5), Position(3, 3))
      )
    }
  
    "produce correct sequence of steps when initial position is (5, 5) and all positions were already visited" in {
      val step = Step(Position(5, 5), List(
        Position(5, 2), Position(7, 3), Position(8, 5), Position(7, 7),
        Position(5, 8), Position(3, 7), Position(2, 5), Position(3, 3))
      )
      
      val steps = step.explode()
      val positions = steps.map(_.position)
    
      positions should be(List.empty)
    }
  }
}
