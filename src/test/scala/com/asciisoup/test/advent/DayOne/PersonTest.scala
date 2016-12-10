/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayOne

import com.asciisoup.advent.DayOne._
import org.scalatest.{FlatSpec, Matchers}

class PersonTest extends FlatSpec with Matchers {
  "A Person" should "have a location" in {
    val person = Person(Orientation.North, Point(0, 0))
    person.location should be (Point(0, 0))
  }

  "A Person" should "be able to turn right and walk forward one step" in {
    val person = Person(Orientation.North, Point(0, 0))
    person follow List(Instruction(Direction.Right, 1))
    person.location should be (Point(1, 0))
  }

  "A Person" should "be able to turn left and walk forward one step" in {
    val person = Person(Orientation.North, Point(0, 0))
    person follow List(Instruction(Direction.Left, 1))
    person.location should be (Point(-1, 0))
  }

  "A Person" should "be able to turn in many directions" in {
    val person = Person(Orientation.South, Point(10, 10))
    person follow List(Instruction(Direction.Left, 1))
    person follow List(Instruction(Direction.Left, 2))
    person follow List(Instruction(Direction.Left, 7))
    person follow List(Instruction(Direction.Left, 3))
    person follow List(Instruction(Direction.Right, 2))
    person follow List(Instruction(Direction.Left, 1))
    person.location should be (Point(2, 8))
  }
}
