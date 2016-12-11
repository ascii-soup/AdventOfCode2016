/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayFour

import scala.io.Source

object Puzzle2 extends App {

  def decryptName(s: String, rotations: Int): String = {
    s.toList.map(c => decryptChar(c, rotations)).mkString
  }

  def decryptChar(c: Char, rotations: Int): Char = {
    if (c == '-') {
      return ' '
    }
    val alphabet = "abcdefghijklmnopqrstuvwxyz".toList
    val circularAlphabet = CircularList(alphabet, c)
    var decrypted: Char = c
    for (_ <- 0 until (rotations % alphabet.size)) {
      decrypted = circularAlphabet.next
    }

    decrypted
  }

  val input = Source.fromInputStream(getClass.getResourceAsStream("/day_four.txt"))

  val rooms: Seq[Room] = input.getLines().map(s => Room.fromString(s)).filter(_.isReal).toSeq

  val roomNames: Seq[String] = rooms.map(r => r.sectorId.toString + ": " + decryptName(r.encryptedName, r.sectorId))
  println(roomNames.mkString("\n"))

  input.close()
}
