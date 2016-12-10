/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.advent.DayOne

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
    * The absolute value of this Point
    *
    * @return
    */
  def abs: Point = {
    Point(scala.math.abs(this.x), scala.math.abs(this.y))
  }

  /**
    *
    * @param source The source Point from which to calculate distance to this Point
    * @return
    */
  def rectilinearDistanceFrom (source: Point): Long = {
    val distancePoint = (this - source).abs
    distancePoint.x + distancePoint.y
  }

}
