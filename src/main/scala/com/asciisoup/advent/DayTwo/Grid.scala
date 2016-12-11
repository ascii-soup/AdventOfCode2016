/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayTwo

object Grid {

  type Row = List[Cell]

  def fromDimensions(dimensions: Dimensions): Grid = {
    def makeRow(width: Int, multiplier: Int): Row = {
      (1 to width)
        .map(x => FilledCell((x + (width * multiplier)).toString))
        .toList
    }

    val grid = (0 until dimensions.height)
      .map(y => makeRow(dimensions.width, y))
      .toList

    new Grid(grid)
  }

}

class Grid (cells: List[List[Cell]]) {
  def toList: List[List[Cell]] = cells

  def cellAt(point: Point): Cell = {
    try {
      cells(point.y)(point.x)
    } catch {
      case e: IndexOutOfBoundsException => new EmptyCell
      case e: Exception => throw e
    }
  }

  def find(value: String): Point = {
    for (y <- cells.indices) {
      for (x <- cells(y).indices) {
        if (cells(y)(x).value == value) {
          return Point(x, y)
        }
      }
    }
    throw new ArrayIndexOutOfBoundsException(value + " cannot be found in the grid")
  }
}
