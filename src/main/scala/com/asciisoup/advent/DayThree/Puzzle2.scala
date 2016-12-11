/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayThree

import scala.io.Source

object Puzzle2 extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_three.txt"))

  // Grab rows as before and then transpose into columns
  val inputs: List[List[Int]] = input.getLines().map(line => {
      val columns = line.trim().split(" +")
      List(columns(0).toInt, columns(1).toInt, columns(2).toInt)
    }
  ).toList.transpose

  // Concat the columns together and
  // chunk into groups of 3 to
  // make triangles
  val triangles: List[Triangle] =
    (inputs(0) ::: inputs(1) ::: inputs(2))
    .grouped(3)
    .toList
    .map(xs => Triangle(xs(0), xs(1), xs(2)))

  println(triangles.count(_.isValid))

  input.close()
}
