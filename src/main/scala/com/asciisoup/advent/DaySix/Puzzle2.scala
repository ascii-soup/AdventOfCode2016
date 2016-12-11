/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DaySix

import scala.io.Source

object Puzzle2 extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_six.txt"))

  println(
    input.getLines()
        .map(s => s.toList) // read line into a list of rows
        .toSeq
        .transpose // transpose to a list of columns
        .map(xs => {
          xs.groupBy(identity) // chunk the list into char occurrences
            .mapValues(_.size) // create (Char -> Occurrences) map
            .toSeq
            .sortWith(_._2 < _._2) // put it in ascending order
            .map(c => c._1) // make it a list of just the chars
            .head // pop off the first (most frequent) char
        })
        .mkString // stitch the whole lot together into a string
  )

  input.close()
}
