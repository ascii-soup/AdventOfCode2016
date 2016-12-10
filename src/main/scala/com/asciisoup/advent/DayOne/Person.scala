/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

case class Person(var facing: Direction.Value, origin: Point) {

  val directions = CircularList(
    List(Direction.North, Direction.East, Direction.South, Direction.West),
    facing
  )

  private var _location: Point = origin

  def location: Point = {
    _location
  }

  def turnRightAndWalkForward (steps: Int): Unit = {
    facing = directions.next
    walkForward(steps)
  }

  def turnLeftAndWalkForward (steps: Int): Unit = {
    facing = directions.prev
    walkForward(steps)
  }

  private def walkForward (steps: Int): Unit = {
    _location += (facing match {
      case Direction.North => Point(0, steps)
      case Direction.East  => Point(steps, 0)
      case Direction.South => Point(0, -steps)
      case Direction.West  => Point(-steps, 0)
    })
  }
}
