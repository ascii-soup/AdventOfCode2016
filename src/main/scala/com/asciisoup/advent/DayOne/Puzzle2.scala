/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

import scala.io.Source

object Puzzle2 extends App {

  def gps(location: Point): Unit = {
    if (visitedLocations.contains(location)) {
      println(location.rectilinearDistanceFrom(Point(0, 0)))
      System.exit(0)
    }
    visitedLocations = location :: visitedLocations
  }

  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_one.txt"))
  val instructions = Instructions(input.mkString)
  input.close()

  val person = Person(Orientation.North, Point(0, 0))
  var visitedLocations = List[Point]()
  person.observedBy(gps)
  person.follow(instructions.asList)
}

