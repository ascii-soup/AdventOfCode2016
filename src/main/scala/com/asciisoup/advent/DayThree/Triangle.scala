/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayThree

case class Triangle (sideOne: Int, sideTwo: Int, sideThree: Int) {
  def isValid: Boolean = {
    (sideOne + sideTwo > sideThree) && (sideTwo + sideThree > sideOne) && (sideOne + sideThree > sideTwo)
  }
}
