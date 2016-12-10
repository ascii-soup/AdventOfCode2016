/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

case class CircularList[T](list: List[T]) {

  private var index: Int = 0

  def next: T = {
    if (index + 1 >= list.length) {
      index = index % list.length
    }

    val x = list(index)
    index += 1
    x
  }

  def prev: T = {
    if (index - 1 < 0) {
      index = list.length
    }

    index -= 1
    list(index)
  }

}
