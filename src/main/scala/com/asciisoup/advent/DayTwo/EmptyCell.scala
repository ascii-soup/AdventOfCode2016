/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayTwo

class EmptyCell extends Cell {
  override def hasContent: Boolean = false

  override def value: String = ""
}
