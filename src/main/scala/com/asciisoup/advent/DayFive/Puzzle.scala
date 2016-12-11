/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayFive

object Puzzle extends App {

  def predicate (md5: String, suffix: Int): Boolean = {
    if (md5.startsWith("00000")) {
      println(suffix.toString + ": " + md5)
    }

    md5.startsWith("00000")
  }

  val generator = HashGenerator("wtnhxymk")
  println(
    generator.generate(8, predicate)
    .map(s => s.substring(5, 6))
    .mkString)
}
