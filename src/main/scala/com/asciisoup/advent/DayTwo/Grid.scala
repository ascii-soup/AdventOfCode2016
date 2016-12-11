/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayTwo

case class Grid (dimensions: Dimensions) {

  type Row = List[Int]
  type Grid = List[Row]

  private def makeRow(width: Int, multiplier: Int): Row = {
    (1 to width)
      .map(x => x + (width * multiplier))
      .toList
  }

  private def makeGrid (dimensions: Dimensions): Grid = {
    (0 until dimensions.height)
      .map(y => makeRow(dimensions.width, y))
      .toList
  }

  def toList: Grid = {
    makeGrid(dimensions)
  }

}
