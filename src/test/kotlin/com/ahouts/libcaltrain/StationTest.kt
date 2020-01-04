package com.ahouts.libcaltrain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StationTest {

    @Test
    fun roundTrip() {
        for (subclass in Station::class.sealedSubclasses) {
            val s = subclass.objectInstance.toString()
            assertEquals(Station.fromString(s)!!::class, subclass)
        }
    }

    @Test
    fun parseInvalid() {
        assertNull(Station.fromString("abc"))
        assertNull(Station.fromString(""))
    }

}