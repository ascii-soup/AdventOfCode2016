/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayOne

import com.asciisoup.advent.DayOne.{Orientation, Point, Person}
import org.scalatest.{FlatSpec, Matchers}

class PersonTest extends FlatSpec with Matchers {
  "A Person" should "have a location" in {
    val person = Person(Orientation.North, Point(0, 0))
    person.location should be (Point(0, 0))
  }

  "A Person" should "be able to turn right and walk forward one step" in {
    val person = Person(Orientation.North, Point(0, 0))
    person turnRightAndWalkForward 1
    person.location should be (Point(1, 0))
  }

  "A Person" should "be able to turn left and walk forward one step" in {
    val person = Person(Orientation.North, Point(0, 0))
    person turnLeftAndWalkForward 1
    person.location should be (Point(-1, 0))
  }

  "A Person" should "be able to turn in many directions" in {
    val person = Person(Orientation.South, Point(10, 10))
    person turnLeftAndWalkForward 1
    person turnLeftAndWalkForward 2
    person turnLeftAndWalkForward 7
    person turnLeftAndWalkForward 3
    person turnRightAndWalkForward 2
    person turnLeftAndWalkForward 1
    person.location should be (Point(2, 8))
  }
}
