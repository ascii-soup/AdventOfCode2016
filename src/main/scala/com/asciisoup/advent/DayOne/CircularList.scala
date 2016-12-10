/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

case class CircularList[T](list: List[T], startAt: T) {

  private var index: Int = list.indexOf(startAt)

  def next: T = {
    if (index + 1 == list.length) {
      index = -1
    }

    index += 1
    list(index)
  }

  def prev: T = {
    if (index - 1 < 0) {
      index = list.length
    }

    index -= 1
    list(index)
  }

}
