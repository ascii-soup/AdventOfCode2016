package com.asciisoup.advent.DayTwo

/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

case class Keypad (dimensions: Dimensions, start: Int) {

  private val grid = Grid(dimensions).toList

  var position: Point = findStart

  private def findStart: Point = {
    for (y <- grid.indices) {
      for (x <- grid(y).indices) {
        if (grid(y)(x) == start) {
          return Point(x, y)
        }
      }
    }
    throw new ArrayIndexOutOfBoundsException(start + " cannot be found in the grid")
  }

  def current: Int = {
    grid(position.y)(position.x)
  }

  def move(direction: Direction.Value): Unit = {
    val target = direction match {
      case Direction.Up => position + Point(0, -1)
      case Direction.Down => position + Point(0, 1)
      case Direction.Left => position + Point(-1, 0)
      case Direction.Right => position + Point(1, 0)
    }

    position = clamp(target, Point(0, 0), Point(dimensions.width - 1, dimensions.height - 1))
  }

  private def clamp(point: Point, min: Point, max: Point): Point = {
    val x = if (point.x < min.x) min.x else if (point.x > max.x) max.x else point.x
    val y = if (point.y < min.y) min.y else if (point.y > max.y) max.y else point.y
    Point(x, y)
  }

}
