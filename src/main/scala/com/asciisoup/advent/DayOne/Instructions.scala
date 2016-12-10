/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

case class Instructions (source: String) {

  def asList: List[Instruction] = {
    parse.toList
  }

  private def parse = {
    source.split(", ").map(
      s => Instruction(Direction.withName(s.substring(0, 1)), s.substring(1).toInt)
    )
  }
}
