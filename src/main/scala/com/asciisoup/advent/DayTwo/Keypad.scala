package com.asciisoup.advent.DayTwo

/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

case class Keypad (grid: Grid, start: String) {

  var position: Point = grid.find(start)

  def current: String = {
    grid.cellAt(position).value
  }

  def move(direction: Direction.Value): Unit = {
    val target = direction match {
      case Direction.Up => position + Point(0, -1)
      case Direction.Down => position + Point(0, 1)
      case Direction.Left => position + Point(-1, 0)
      case Direction.Right => position + Point(1, 0)
    }

    if (grid.cellAt(target).hasContent) {
      position = target
    }
  }

}
