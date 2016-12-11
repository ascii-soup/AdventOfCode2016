/*
 * Copyright ASCII Soup (Nils Luxton) (c) 2016.
 *
 * GNU GPL v3 - See LICENSE.txt for details
 */

package com.asciisoup.test.advent.DayFour

import com.asciisoup.advent.DayFour.Room
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class RoomTest extends FlatSpec with Matchers {
  "A Room" can "be created from a string" in {
    val room = Room.fromString("aaaaa-bbb-z-y-x-123[abxyz]")

    room.encryptedName should be ("aaaaa-bbb-z-y-x")
    room.sectorId should be (123)
    room.checksum should be ("abxyz")
  }

  val rooms = Table(
    ("room", "is_real"),
    ("aaaaa-bbb-z-y-x-123[abxyz]", true),
    ("a-b-c-d-e-f-g-h-987[abcde]", true),
    ("not-a-real-room-404[oarel]", true),
    ("totally-real-room-200[decoy]", false)
  )

  "A Room" can "be real only if the checksum is the most common letters in the name" in {
    forAll (rooms) { (room: String, isReal: Boolean) =>
      Room.fromString(room).isReal should be (isReal)
    }
  }
}
