package com.ahouts.libcaltrain

import org.jsoup.Jsoup
import java.io.InputStream
import java.time.LocalTime

fun parseMobileDepartures(html: InputStream, currentTime: LocalTime): Departures {
    val doc = Jsoup.parse(html, "UTF-8", "http://www.caltrain.com")

    val directions = doc.selectFirst(".ipf-st-ip-trains-table-dir-tr")
        .children()
        .map { it.child(0) }
        .map { it.text() }
        .mapNotNull { Direction.fromString(it) }

    val times = doc.selectFirst(".ipf-st-ip-trains-table-trains-tr")
        .children()
        .map { it.select(".ipf-st-ip-trains-subtable-tr") }
        .map { rows ->
            rows.map { row ->
                val trainNo = row.selectFirst(".ipf-st-ip-trains-subtable-td-id")
                    .text()
                    .toInt()
                    .let { TrainNo(it) }

                val trainType = row.selectFirst(".ipf-st-ip-trains-subtable-td-type")
                    .text()
                    .let { TrainType.fromString(it) }

                val departureTime = row.selectFirst(".ipf-st-ip-trains-subtable-td-arrivaltime")
                    .text()
                    .let { it.split("min.")[0].trim() }
                    .toLong()
                    .let { currentTime.plusMinutes(it) }

                Departure(trainNo, trainType ?: TrainType.Local, departureTime)
            }
        }

    val data = directions.zip(times)

    val northbound = data.firstOrNull { it.first == Direction.Northbound }?.second
    val southbound = data.firstOrNull { it.first == Direction.Southbound }?.second

    return Departures(northbound ?: listOf(), southbound ?: listOf())
}
