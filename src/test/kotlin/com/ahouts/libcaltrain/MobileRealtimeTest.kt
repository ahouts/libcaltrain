package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.TrainType.BabyBullet
import com.ahouts.libcaltrain.TrainType.Local
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalTime

internal class MobileRealtimeTest {

    private val now = LocalTime.of(3, 0, 0)

    @Test
    fun parseMobileDepartures() {
        assertEquals(
            Departures(
                listOf(
                    Departure(433, Local, now.plusMinutes(59)),
                    Departure(435, Local, now.plusMinutes(149)),
                    Departure(437, Local, now.plusMinutes(239))
                ), listOf(
                    Departure(434, Local, now.plusMinutes(50)),
                    Departure(436, Local, now.plusMinutes(140)),
                    Departure(438, Local, now.plusMinutes(230))
                )
            ),
            parseMobileDepartures(acquireResource("south-sf-mobile.html"), now)
        )
    }

    @Test
    fun parseMobileDepartures_onlySouthbound() {
        assertEquals(
            Departures(
                listOf(),
                listOf(
                    Departure(434, Local, now.plusMinutes(13)),
                    Departure(436, Local, now.plusMinutes(103)),
                    Departure(804, BabyBullet, now.plusMinutes(160))
                )
            ),
            parseMobileDepartures(acquireResource("sf-mobile.html"), now)
        )
    }

    @Test
    fun parseMobileDepartures_noTrains() {
        assertEquals(
            Departures(listOf(), listOf()),
            parseMobileDepartures(acquireResource("tamien-mobile-weekend.html"), now)
        )
    }

    private fun acquireResource(resource: String) =
        javaClass.classLoader.getResourceAsStream("com/ahouts/libcaltrain/$resource")!!

}