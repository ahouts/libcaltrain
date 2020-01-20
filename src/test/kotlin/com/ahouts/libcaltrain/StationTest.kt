package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Station.*
import com.ahouts.libcaltrain.Station.Companion.STATIONS
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StationTest {

    @Test
    fun `serialization round trip works`() {
        for (station in STATIONS) {
            assertEquals(Station.fromString(station.toString()), station)
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