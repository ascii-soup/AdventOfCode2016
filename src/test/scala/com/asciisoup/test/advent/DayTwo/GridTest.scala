/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayTwo

import com.asciisoup.advent.DayTwo.{Dimensions, Grid}
import org.scalatest.{FlatSpec, Matchers}

class GridTest extends FlatSpec with Matchers {

  "A Grid" should "create a 2D list of Ints" in {
    val grid = Grid(Dimensions(2, 2))
    grid.toList should be (List(List(1, 2), List(3, 4)))
  }

  "A Grid" can "generated lists of many sizes" in {
    val grid = Grid(Dimensions(3, 3))
    grid.toList should be (List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)))
  }

}
