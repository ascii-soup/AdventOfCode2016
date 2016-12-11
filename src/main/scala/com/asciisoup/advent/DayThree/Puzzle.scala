/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayThree

import scala.io.Source

object Puzzle extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_three.txt"))

  val triangles: List[Triangle] = input.getLines().map(line => {
      val columns = line.trim().split(" +")
      Triangle(columns(0).toInt, columns(1).toInt, columns(2).toInt)
    }
  ).toList

  println(triangles.count(_.isValid))

  input.close()
}
