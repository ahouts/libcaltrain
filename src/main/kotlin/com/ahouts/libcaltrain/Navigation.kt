package com.ahouts.libcaltrain

import java.time.LocalTime

typealias Route = List<TimetableDeparture>

fun Timetable.getRoutes(start: Station, dest: Station, startTime: LocalTime): Route {
    val arrivals = this[dest]!!
        .filter { it.departure.departureTime > startTime }
        .sortedBy { it.departure.departureTime }

    arrivals.map { arrival ->

    }

    return listOf<TimetableDeparture>()
}
