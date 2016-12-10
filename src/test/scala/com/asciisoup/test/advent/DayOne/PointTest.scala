/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayOne

import com.asciisoup.advent.DayOne.Point
import org.scalatest.{FlatSpec, Matchers}

class PointTest extends FlatSpec with Matchers {

  "A Point" should "represent a pair of Cartesian coordinates" in {
    val point = Point(1, 2)
    point.x should be (1)
    point.y should be (2)
  }

  "A Point" should "support subtraction from another Point" in {
    val pointA = Point(1, 2)
    val pointB = Point(1, 1)

    (pointA - pointB) should be (Point(0, 1))
  }

  "A Point" should "support giving its absolute value" in {
    val point = Point(-1, -2)
    point.abs should be (Point(1, 2))
  }

  "A Point" should "calculate its rectilinear distance from another Point" in {
    val pointA = Point(1, 2)
    val pointB = Point(6, 8)

    (pointB rectilinearDistanceFrom pointA) should be (11)
  }
}
