/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayOne

import com.asciisoup.advent.DayOne.CircularList
import org.scalatest.{FlatSpec, Matchers}

class CircularListTest extends FlatSpec with Matchers {

  "A Circular List" should "give you the next item" in {
    val list = CircularList(List(1, 2, 3), 1)
    list.next should be (2)
  }

  "A Circular List" should "give you the previous item" in {
    val list = CircularList(List(1, 2, 3), 1)
    list.prev should be (3)
  }

  "A Circular List" should "wrap when it reaches the end" in {
    val list = CircularList(List(1, 2, 3), 1)
    list.next should be (2)
    list.next should be (3)
    list.next should be (1)
  }

  "A Circular List" should "wrap when it reaches the beginning" in {
    val list = CircularList(List(1, 2, 3), 1)
    list.prev should be (3)
    list.prev should be (2)
    list.prev should be (1)
    list.prev should be (3)
  }

  "A Circular List" should "start at the given element" in {
    val list = CircularList(List(1, 2, 3), 2)
    list.next should be (3)
  }

}
