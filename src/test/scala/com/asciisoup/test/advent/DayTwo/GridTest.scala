/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayTwo

import com.asciisoup.advent.DayTwo.{Dimensions, FilledCell, Grid}
import org.scalatest.{FlatSpec, Matchers}

class GridTest extends FlatSpec with Matchers {

  "A Grid" should "create a 2D list of Ints" in {
    val grid = Grid.fromDimensions(Dimensions(2, 2))
    grid.toList should be (
      List(
        List(FilledCell("1"), FilledCell("2")),
        List(FilledCell("3"), FilledCell("4"))
      )
    )
  }

  "A Grid" can "generated lists of many sizes" in {
    val grid = Grid.fromDimensions(Dimensions(3, 3))
    grid.toList should be (
      List(
        List(FilledCell("1"), FilledCell("2"), FilledCell("3")),
        List(FilledCell("4"), FilledCell("5"), FilledCell("6")),
        List(FilledCell("7"), FilledCell("8"), FilledCell("9"))
      )
    )
  }

}
