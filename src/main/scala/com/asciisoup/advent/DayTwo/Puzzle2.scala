/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayTwo

import scala.io.Source

object Puzzle2 extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_two.txt"))

  val theGrid = new Grid(List(
    List(new EmptyCell,   new EmptyCell,   FilledCell("1"), new EmptyCell,   new EmptyCell),
    List(new EmptyCell,   FilledCell("2"), FilledCell("3"), FilledCell("4"), new EmptyCell),
    List(FilledCell("5"), FilledCell("6"), FilledCell("7"), FilledCell("8"), FilledCell("9")),
    List(new EmptyCell,   FilledCell("A"), FilledCell("B"), FilledCell("C"), new EmptyCell),
    List(new EmptyCell,   new EmptyCell,   FilledCell("D"), new EmptyCell,   new EmptyCell)
  ))

  val keypad = Keypad(theGrid, "5")
  for (line <- input.getLines()) {
    for (s <- line.toList) {
      keypad.move(Direction.withName(s.toString.toUpperCase()))
    }
    print(keypad.current)
  }

  input.close()
}
