package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Direction.*
import com.ahouts.libcaltrain.Station.*
import com.ahouts.libcaltrain.TrainType.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalTime

internal class TimetableTest {

    @Test
    fun `parseTimetable works`() {
        val timetable = parseTimetable(javaClass.acquireResource("timetable-weekday.html"))
        assertEquals(
            listOf(
                TimetableDeparture(Northbound, Departure(TrainNo(217), Limited, LocalTime.of(6, 6))),
                TimetableDeparture(Northbound, Departure(TrainNo(221), Limited, LocalTime.of(6, 28))),
                TimetableDeparture(Northbound, Departure(TrainNo(227), Limited, LocalTime.of(7, 6))),
                TimetableDeparture(Southbound, Departure(TrainNo(156), Local, LocalTime.of(17, 37))),
                TimetableDeparture(Southbound, Departure(TrainNo(262), Limited, LocalTime.of(18, 35))),
                TimetableDeparture(Southbound, Departure(TrainNo(268), Limited, LocalTime.of(19, 18)))
            ),
            timetable.departures[Gilroy]
        )
        assertEquals(
            TimetableDeparture(Southbound, Departure(TrainNo(376), BabyBullet, LocalTime.of(18, 17))),
            timetable.departures[PaloAlto]?.first { it.direction == Southbound && it.departure.trainNo.no == 376 }
        )
    }
}