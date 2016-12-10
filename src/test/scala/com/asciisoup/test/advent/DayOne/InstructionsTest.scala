/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayOne

import com.asciisoup.advent.DayOne.{Direction, Instruction, Instructions}
import org.scalatest.{FlatSpec, Matchers}

class InstructionsTest extends FlatSpec with Matchers {
  "Instructions" should "provide a list given a string" in {
    val instructions = Instructions("L3, R4")
    instructions.asList should be(
      List(
        Instruction(Direction.Left, 3),
        Instruction(Direction.Right, 4)
      )
    )
  }
}
