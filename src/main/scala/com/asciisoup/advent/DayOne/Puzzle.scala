/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

import scala.io.Source

object Puzzle extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_one.txt"))
  val instructions = Instructions(input.mkString)
  input.close()

  val person = Person(Orientation.North, Point(0, 0))
  person.follow(instructions.asList)

  println(person.location.rectilinearDistanceFrom(Point(0, 0)))
}
