/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

case class Person(var facing: Orientation.Value, origin: Point) {

  val directions = CircularList(
    List(Orientation.North, Orientation.East, Orientation.South, Orientation.West),
    facing
  )

  private var _location: Point = origin

  def location: Point = {
    _location
  }

  def follow (instructions: List[Instruction]): Unit = {
    instructions.foreach(
      (instruction) => {
        instruction.direction match {
          case Direction.Left => facing = directions.prev
          case Direction.Right => facing = directions.next
        }
        walkForward(instruction.steps)
      }
    )
  }

  private def walkForward (steps: Int): Unit = {
    _location += (facing match {
      case Orientation.North => Point(0, steps)
      case Orientation.East  => Point(steps, 0)
      case Orientation.South => Point(0, -steps)
      case Orientation.West  => Point(-steps, 0)
    })
  }
}
