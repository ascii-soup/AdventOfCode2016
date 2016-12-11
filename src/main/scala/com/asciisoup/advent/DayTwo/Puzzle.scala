/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayTwo

import scala.io.Source

object Puzzle extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_two.txt"))

  val keypad = Keypad(Dimensions(3, 3), 5)
  for (line <- input.getLines()) {
    for (s <- line.toList) {
      keypad.move(Direction.withName(s.toString.toUpperCase()))
    }
    print(keypad.current)
  }

  input.close()
}
