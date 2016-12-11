/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayTwo

/**
  * Represents a 2D point in a Cartesian coordinates system
  *
  * @param x X coordinate
  * @param y Y coordinate
  */
case class Point(x: Int, y: Int) {
  /**
    * Subtract one Point from another
    *
    * @param point The Point to subtract from this Point
    * @return
    */
  def - (point: Point): Point = {
    Point(this.x - point.x, this.y - point.y)
  }

  /**
    * Add two Points together
    *
    * @param point The Point to add to this Point
    * @return
    */
  def + (point: Point): Point = {
    Point(this.x + point.x, this.y + point.y)
  }



}
