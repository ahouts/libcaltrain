package com.ahouts.libcaltrain

import java.time.LocalTime
import java.util.*

data class TrainNo(val no: Int)

sealed class TrainType {

    object Local : TrainType()

    object Limited : TrainType()

    object BabyBullet : TrainType()

    companion object {

        fun fromString(s: String): TrainType? =
            when (s.toLowerCase(Locale.US).replace(" ", "")) {
                "local" -> Local
                "limited" -> Limited
                "babybullet" -> BabyBullet
                else -> null
            }

    }

}

sealed class Direction {

    object Northbound : Direction()

    object Southbound : Direction()

    companion object {

        fun fromString(s: String): Direction? =
            when (s.toLowerCase(Locale.US).split(" ")[0]) {
                "northbound" -> Northbound
                "southbound" -> Southbound
                else -> null
            }

    }

}

data class Departure(val trainNo: TrainNo, val trainType: TrainType, val departureTime: LocalTime)

data class Departures(val northbound: List<Departure>, val southbound: List<Departure>)
