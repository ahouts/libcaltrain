package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Direction.Northbound
import com.ahouts.libcaltrain.Direction.Southbound
import com.ahouts.libcaltrain.TrainType.*
import org.jsoup.Jsoup
import java.io.InputStream
import java.time.LocalTime
import java.util.*

const val WEEKDAY_TIMETABLE_URL: String = "http://www.caltrain.com/schedules/weekdaytimetable.html"

private val NUMERIC_REGEX = Regex("[0-9 ]+")
private val RANDOM_TABLE_GARBAGE = Regex("[+*]")

data class Timetable(val departures: Map<Station, List<TimetableDeparture>>)

data class TimetableDeparture(val direction: Direction, val departure: Departure)

fun parseTimetable(html: InputStream): Timetable {
    val doc = Jsoup.parse(html, "UTF-8", "http://www.caltrain.com")

    val departuresData = listOf(doc.select(".NB_TT"), doc.select(".SB_TT"))
        .flatten()
        .flatMap { table ->
            val direction = table.attr("summary")
                .split(" ")
                .map { it.toLowerCase(Locale.US) }
                .mapNotNull { if (it == "northbound") Northbound else if (it == "southbound") Southbound else null }
                .first()

            val trainNos = table.children()
                .first { it.tagName() == "thead" }
                .child(0)
                .children()
                .map { it.text().trim().replace("*", "") }
                .map { if (NUMERIC_REGEX.matchEntire(it) != null) TrainNo(it.toInt()) else null }

            val trainDepartureData = table.children()
                .first { it.tagName() == "tbody" }
                .children()
                .map { stationHtml ->
                    val station = stationHtml.children()
                        .drop(1)
                        .first()
                        .children()
                        .first()
                        .attr("title")
                        .let { Station.fromString(it)!! }

                    val trainArrivals = stationHtml.children()
                        .map train@{ train ->
                            if (train.tagName() != "td") {
                                return@train null
                            }

                            val classes = train.className().split(" ")
                            val text = train.text().trim().replace(RANDOM_TABLE_GARBAGE, "")
                            if (text.length <= 1) {
                                return@train null
                            }

                            val trainType = when {
                                classes.contains("bullet") -> BabyBullet
                                classes.contains("limited") -> Limited
                                else -> Local
                            }

                            val isAm = text.last() == 'a'
                            val hoursMinutes = text.substring(0 until (text.length - 1))
                                .split(":")
                                .map(String::toInt)
                            val partialDepartureTime = LocalTime.of(hoursMinutes[0], hoursMinutes[1])
                            val departureTime = if (isAm) partialDepartureTime else partialDepartureTime.plusHours(12)!!

                            Pair(trainType, departureTime)
                        }

                    trainArrivals.map { Triple(station, it?.first, it?.second) }
                }

            trainNos.zip(trainDepartureData.transpose())
                .filter { it.first != null }
                .flatMap { pair ->
                    pair.second
                        .filter { it.second != null }
                        .filter { it.third != null }
                        .map {
                            Pair(
                                it.first,
                                TimetableDeparture(direction, Departure(pair.first!!, it.second!!, it.third!!))
                            )
                        }
                }
        }
        .groupBy { it.first }
        .map { entry -> Pair(entry.key, entry.value.map { it.second }) }
        .toMap()

    return Timetable(departuresData)
}

private fun <T> List<List<T>>.transpose(): List<List<T>> {
    val res = mutableListOf<MutableList<T>>()

    for (j in this[0].indices) {
        res.add(mutableListOf())
        for (i in this.indices) {
            res[j].add(this[i][j])
        }
    }

    return res
}
