/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayFive

case class HashGenerator(input: String) {

  def generate (length: Int, predicate: (String, Int) => Boolean): Seq[String] = {
    md5sWhere(predicate)
      .take(length)
  }

  private def md5sWhere(predicate: (String, Int) => Boolean): Seq[String] = {
    for (suffix <- Stream.from(0) if predicate(md5(input + suffix.toString), suffix))
      yield md5(input + suffix.toString)
  }

  private def md5(s: String) : String = {
    java.security.MessageDigest.getInstance("MD5")
      .digest(s.getBytes())
      .map(0xFF & _)
      .map { "%02x".format(_) }
      .foldLeft("") {_ + _}
  }

}
