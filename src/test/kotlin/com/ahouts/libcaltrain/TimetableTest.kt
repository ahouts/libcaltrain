package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Direction.*
import com.ahouts.libcaltrain.Station.*
import com.ahouts.libcaltrain.TrainType.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalTime

internal class TimetableTest {

    private val now = LocalTime.of(3, 0, 0)

    @Test
    fun `parseTimetable works`() {
        val timetable = parseTimetable(javaClass.acquireResource("timetable-weekday.html"))
        assertEquals(
            listOf(
                TimetableDeparture(Northbound, Departure(TrainNo(217), Limited, LocalTime.of(6, 6)), false),
                TimetableDeparture(Northbound, Departure(TrainNo(221), Limited, LocalTime.of(6, 28)), false),
                TimetableDeparture(Northbound, Departure(TrainNo(227), Limited, LocalTime.of(7, 6)), false),
                TimetableDeparture(Southbound, Departure(TrainNo(156), Local, LocalTime.of(17, 37)), false),
                TimetableDeparture(Southbound, Departure(TrainNo(262), Limited, LocalTime.of(18, 35)), false),
                TimetableDeparture(Southbound, Departure(TrainNo(268), Limited, LocalTime.of(19, 18)), false)
            ),
            timetable.departures[Gilroy]
        )
        assertEquals(
            TimetableDeparture(Southbound, Departure(TrainNo(376), BabyBullet, LocalTime.of(18, 17)), false),
            timetable.departures[PaloAlto]?.first { it.direction == Southbound && it.departure.trainNo.no == 376 }
        )
    }

    @Test
    fun `insertRealtimeData works`() {
        val timetable = parseTimetable(javaClass.acquireResource("timetable-weekday.html"))
        val realtime = Departures(
            listOf(
                Departure(TrainNo(103), Local, LocalTime.of(6, 21)),
                Departure(TrainNo(207), Limited, LocalTime.of(7, 15))
            ), listOf(
                Departure(TrainNo(104), Local, LocalTime.of(5, 35)),
                Departure(TrainNo(208), Limited, LocalTime.of(6, 32)),
                Departure(TrainNo(310), BabyBullet, LocalTime.of(6, 42))
            )
        )
        val updated = insertRealtimeData(timetable, SouthSanFrancisco, realtime)

        assertEquals(
            listOf(
                TimetableDeparture(Northbound, Departure(TrainNo(101), Local, LocalTime.of(5, 45)), false),
                TimetableDeparture(Northbound, Departure(TrainNo(103), Local, LocalTime.of(6, 21)), true),
                TimetableDeparture(Northbound, Departure(TrainNo(207), Limited, LocalTime.of(7, 15)), true)
            ),
            updated.departures[SouthSanFrancisco]!!
                .filter { it.direction == Northbound }
                .filter { it.departure.departureTime <= LocalTime.of(7, 15) }
        )

        assertEquals(
            listOf(
                TimetableDeparture(Southbound, Departure(TrainNo(102), Local, LocalTime.of(5, 10)), false),
                TimetableDeparture(Southbound, Departure(TrainNo(104), Local, LocalTime.of(5, 35)), true),
                TimetableDeparture(Southbound, Departure(TrainNo(208), Limited, LocalTime.of(6, 32)), true),
                TimetableDeparture(Southbound, Departure(TrainNo(310), BabyBullet, LocalTime.of(6, 42)), true)
            ),
            updated.departures[SouthSanFrancisco]!!
                .filter { it.direction == Southbound }
                .filter { it.departure.departureTime <= LocalTime.of(6, 42) }
        )
    }

}