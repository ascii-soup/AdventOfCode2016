/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayTwo

import com.asciisoup.advent.DayTwo.{Dimensions, Direction, Keypad}
import org.scalatest.{FlatSpec, Matchers}

class KeypadTest extends FlatSpec with Matchers {
  "A Keypad" should "have a current key" in {
    val keypad = Keypad(Dimensions(3, 3), 5)
    keypad.current should be (5)
  }

  "A Keypad" should "allow moving up" in {
    val keypad = Keypad(Dimensions(3, 3), 5)
    keypad.move(Direction.withName("U"))
    keypad.current should be (2)
  }

  "A Keypad" should "allow moving down" in {
    val keypad = Keypad(Dimensions(3, 3), 5)
    keypad.move(Direction.withName("D"))
    keypad.current should be (8)
  }

  "A Keypad" should "allow moving left" in {
    val keypad = Keypad(Dimensions(3, 3), 5)
    keypad.move(Direction.withName("L"))
    keypad.current should be (4)
  }

  "A Keypad" should "allow moving right" in {
    val keypad = Keypad(Dimensions(3, 3), 5)
    keypad.move(Direction.withName("R"))
    keypad.current should be (6)
  }

  "A Keypad" should "not allow you to move past its bounds" in {
    val keypad = Keypad(Dimensions(3, 3), 5)
    keypad.move(Direction.withName("R"))
    keypad.move(Direction.withName("R"))
    keypad.move(Direction.withName("R"))
    keypad.current should be (6)
  }
}
