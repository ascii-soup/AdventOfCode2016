/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayFive

object Puzzle2 extends App {

  var legalPositions = List(
    "0", "1", "2", "3", "4", "5", "6", "7"
  )

  def predicate (md5: String, suffix: Int): Boolean = {

    val result = md5.startsWith("00000") && legalPositions.contains(md5.substring(5, 6))
    if (result) {
      println(suffix.toString + ": " + md5)
      legalPositions = legalPositions diff List(md5.substring(5, 6))
    }

    result
  }

  val generator = HashGenerator("wtnhxymk")
  println(
    generator.generate(8, predicate)
      .map(hash => (hash.substring(5, 6).toInt, hash.substring(6, 7)))
      .sortBy(_._1)
      .map(_._2)
      .mkString)
}
