/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayTwo

import com.asciisoup.advent.DayOne.Point
import org.scalatest.{FlatSpec, Matchers}

class PointTest extends FlatSpec with Matchers {

  "A Point" should "represent a pair of Cartesian coordinates" in {
    val point = Point(1, 2)
    point.x should be (1)
    point.y should be (2)
  }

  "A Point" can "be subtracted from another Point" in {
    val pointA = Point(1, 2)
    val pointB = Point(1, 1)

    (pointA - pointB) should be (Point(0, 1))
  }

  "A Point" should "support addition to another Point" in {
    val pointA = Point(1, 2)
    val pointB = Point(1, 1)

    (pointA + pointB) should be (Point(2, 3))
  }


}
