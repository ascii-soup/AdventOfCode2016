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
    (1 to steps).foreach( _ => {
      _location += (facing match {
        case Orientation.North => Point(0, 1)
        case Orientation.East  => Point(1, 0)
        case Orientation.South => Point(0, -1)
        case Orientation.West  => Point(-1, 0)
      })
      observer match {
        case Some(f) => f(_location)
        case None => Unit
      }
    })


  }

  private var observer: Option[Point => Unit] = None

  def observedBy(f: Point => Unit): Unit = {
    observer = Some(f)
  }
}
