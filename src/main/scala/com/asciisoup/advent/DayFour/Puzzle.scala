/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayFour

import scala.io.Source

object Puzzle extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_four.txt"))

  val rooms: Seq[Room] = input.getLines().map(s => Room.fromString(s)).filter(_.isReal).toSeq

  println(rooms.map(_.sectorId).sum)

  input.close()
}
