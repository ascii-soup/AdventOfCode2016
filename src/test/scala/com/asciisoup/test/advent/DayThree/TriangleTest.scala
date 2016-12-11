/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayThree

import com.asciisoup.advent.DayThree.Triangle
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class TriangleTest extends FlatSpec with Matchers {

  "The sum of the first two sides of a Triangle" should
  "not be shorter than the remaining side" in {
    val triangle = Triangle(5, 10, 25)
    triangle.isValid should be (false)
  }

  val sides =
    Table(
      ("a", "b", "c", "Result"),
      (  1,   2,   3,    false),
      (  5,  10,  15,    false),
      ( 10,  10,  15,     true),
      ( 15,  10,   5,     false)
    )

  "The sum of any two sides of a Triangle" should
  "be longer than the remaining side" in {

    forAll (sides) { (a: Int, b: Int, c: Int, result: Boolean) =>
      Triangle(a, b, c).isValid should be (result)
    }
  }

}
