package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Station.*
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

    @Test
    fun `compare works`() {
        assertTrue(PaloAlto < SanJoseDiridon)
        assertTrue(SanFrancisco == SanFrancisco)
        assertTrue(SanJoseDiridon > SanFrancisco)
        assertTrue(SanFrancisco < Gilroy)
    }

}