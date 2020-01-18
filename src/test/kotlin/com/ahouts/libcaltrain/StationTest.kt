package com.ahouts.libcaltrain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StationTest {

    @Test
    fun `serialization round trip works`() {
        for (subclass in Station::class.sealedSubclasses) {
            val s = subclass.objectInstance.toString()
            assertEquals(Station.fromString(s)!!::class, subclass)
        }
    }

    @Test
    fun `parsing invalid yields null`() {
        assertNull(Station.fromString("abc"))
        assertNull(Station.fromString(""))
    }

}