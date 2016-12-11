/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayFour

import scala.util.matching.Regex

object Room {
  def fromString(input: String): Room = {
    val pattern = new Regex("([-a-z]+)-([0-9]+)\\[([a-z]+)\\]")
    val pattern(name, sector, checksum) = input
    Room(name, sector.toInt, checksum)
  }
}

case class Room (encryptedName: String, sectorId: Int, checksum: String) {

  def isReal: Boolean = {
    val string = encryptedName.replace("-", "")
      .toSeq
      .groupBy(identity)
      .mapValues(_.size)
      .toSeq
      .sortWith(sort)
      .map(x => x._1)
      .take(5)
      .mkString
    string == checksum
  }

  private def sort(a: (Char, Int), b: (Char, Int)): Boolean = {
    // Sort numerically by count first
    if (a._2 > b._2) {
      return true
    }
    // But if they are the same, sort by alpha
    if (a._2 == b._2) {
      return a._1 < b._1
    }

    false
  }

}
