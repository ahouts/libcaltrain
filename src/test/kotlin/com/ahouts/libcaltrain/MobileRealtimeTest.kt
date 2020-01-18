package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.TrainType.BabyBullet
import com.ahouts.libcaltrain.TrainType.Local
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalTime

internal class MobileRealtimeTest {

    private val now = LocalTime.of(3, 0, 0)

    @Test
    fun `parsing mobile departures works`() {
        assertEquals(
            Departures(
                listOf(
                    Departure(TrainNo(433), Local, now.plusMinutes(59)),
                    Departure(TrainNo(435), Local, now.plusMinutes(149)),
                    Departure(TrainNo(437), Local, now.plusMinutes(239))
                ), listOf(
                    Departure(TrainNo(434), Local, now.plusMinutes(50)),
                    Departure(TrainNo(436), Local, now.plusMinutes(140)),
                    Departure(TrainNo(438), Local, now.plusMinutes(230))
                )
            ),
            parseMobileDepartures(javaClass.acquireResource("south-sf-mobile.html"), now)
        )
    }

    @Test
    fun `parsing only southbound mobile departures works`() {
        assertEquals(
            Departures(
                listOf(),
                listOf(
                    Departure(TrainNo(434), Local, now.plusMinutes(13)),
                    Departure(TrainNo(436), Local, now.plusMinutes(103)),
                    Departure(TrainNo(804), BabyBullet, now.plusMinutes(160))
                )
            ),
            parseMobileDepartures(javaClass.acquireResource("sf-mobile.html"), now)
        )
    }

    @Test
    fun `parsing no mobile departures works`() {
        assertEquals(
            Departures(listOf(), listOf()),
            parseMobileDepartures(javaClass.acquireResource("tamien-mobile-weekend.html"), now)
        )
    }

}