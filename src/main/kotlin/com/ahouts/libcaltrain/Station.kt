package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Direction.*
import com.ahouts.libcaltrain.Zone.*
import java.net.URL
import java.util.*

sealed class Station : Comparable<Station> {

    abstract val displayName: String
    abstract val realtimeMobileUrl: URL
    abstract val zone: Zone
    abstract fun nextInDirection(direction: Direction): Station?
    open val weekdayCommuteOnly: Boolean = false
    open val weekendOnly: Boolean = false

    override fun toString(): String =
        when (this) {
            SanFrancisco -> "SanFrancisco"
            TwentySecondStreet -> "22ndStreet"
            Bayshore -> "Bayshore"
            SouthSanFrancisco -> "SouthSanFrancisco"
            SanBruno -> "SanBruno"
            Millbrae -> "Millbrae"
            Broadway -> "Broadway"
            Burlingame -> "Burlingame"
            SanMateo -> "SanMateo"
            HaywardPark -> "HaywardPark"
            Hillsdale -> "Hillsdale"
            Belmont -> "Belmont"
            SanCarlos -> "SanCarlos"
            RedwoodCity -> "RedwoodCity"
            Atherton -> "Atherton"
            MenloPark -> "MenloPark"
            PaloAlto -> "PaloAlto"
            CaliforniaAve -> "CaliforniaAve"
            SanAntonio -> "SanAntonio"
            MountainView -> "MountainView"
            Sunnyvale -> "Sunnyvale"
            Lawrence -> "Lawrence"
            SantaClara -> "SantaClara"
            CollegePark -> "CollegePark"
            SanJoseDiridon -> "SanJoseDiridon"
            Tamien -> "Tamien"
            Capitol -> "Capitol"
            BlossomHill -> "BlossomHill"
            MorganHill -> "MorganHill"
            SanMartin -> "SanMartin"
            Gilroy -> "Gilroy"
        }

    override fun compareTo(other: Station): Int =
        STATIONS.indexOf(this).compareTo(STATIONS.indexOf(other))

    object SanFrancisco : Station() {
        override val displayName = "San Francisco Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanfranciscostation-mobile.html")
        override val zone = Zone1
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> null
            Southbound -> TwentySecondStreet
        }
    }

    object TwentySecondStreet : Station() {
        override val displayName: String = "22nd Street Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/22ndstreetstation-mobile.html")
        override val zone = Zone1
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanFrancisco
            Southbound -> Bayshore
        }
    }

    object Bayshore : Station() {
        override val displayName: String = "Bayshore Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/bayshorestation-mobile.html")
        override val zone = Zone1
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> TwentySecondStreet
            Southbound -> SouthSanFrancisco
        }
    }

    object SouthSanFrancisco : Station() {
        override val displayName: String = "South San Francisco Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/southsanfranciscostation-mobile.html")
        override val zone = Zone1
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Bayshore
            Southbound -> SanBruno
        }
    }

    object SanBruno : Station() {
        override val displayName: String = "San Bruno Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanbrunostation-mobile.html")
        override val zone = Zone1
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SouthSanFrancisco
            Southbound -> Millbrae
        }
    }

    object Millbrae : Station() {
        override val displayName: String = "Millbrae Transit Center"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/millbraetransitcenter-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanBruno
            Southbound -> Broadway
        }
    }

    object Broadway : Station() {
        override val displayName: String = "Broadway Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/broadwaystation-mobile.html")
        override val zone = Zone2
        override val weekendOnly = true
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Millbrae
            Southbound -> Burlingame
        }
    }

    object Burlingame : Station() {
        override val displayName: String = "Burlingame Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/burlingamestation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Broadway
            Southbound -> SanMateo
        }
    }

    object SanMateo : Station() {
        override val displayName = "San Mateo Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanmateostation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Burlingame
            Southbound -> HaywardPark
        }
    }

    object HaywardPark : Station() {
        override val displayName = "Hayward Park Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/haywardparkstation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanMateo
            Southbound -> Hillsdale
        }
    }

    object Hillsdale : Station() {
        override val displayName = "Hillsdale Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/hillsdalestation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> HaywardPark
            Southbound -> Belmont
        }
    }

    object Belmont : Station() {
        override val displayName = "Belmont Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/belmontstation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Hillsdale
            Southbound -> SanCarlos
        }
    }

    object SanCarlos : Station() {
        override val displayName = "San Carlos Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sancarlosstation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Belmont
            Southbound -> RedwoodCity
        }
    }

    object RedwoodCity : Station() {
        override val displayName = "Redwood City Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/redwoodcitystation-mobile.html")
        override val zone = Zone2
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanCarlos
            Southbound -> Atherton
        }
    }

    object Atherton : Station() {
        override val displayName = "Atherton Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/athertonstation-mobile.html")
        override val zone = Zone3
        override val weekendOnly = true
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> RedwoodCity
            Southbound -> MenloPark
        }
    }

    object MenloPark : Station() {
        override val displayName = "Menlo Park Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/menloparkstation-mobile.html")
        override val zone = Zone3
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Atherton
            Southbound -> PaloAlto
        }
    }

    object PaloAlto : Station() {
        override val displayName = "Palo Alto Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/paloaltostation-mobile.html")
        override val zone = Zone3
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> MenloPark
            Southbound -> CaliforniaAve
        }
    }

    object CaliforniaAve : Station() {
        override val displayName = "California Ave. Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/californiaavestation-mobile.html")
        override val zone = Zone3
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> PaloAlto
            Southbound -> SanAntonio
        }
    }

    object SanAntonio : Station() {
        override val displayName = "San Antonio Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanantoniostation-mobile.html")
        override val zone = Zone3
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> CaliforniaAve
            Southbound -> MountainView
        }
    }

    object MountainView : Station() {
        override val displayName = "Mountain View Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/mountainviewstation-mobile.html")
        override val zone = Zone3
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanAntonio
            Southbound -> Sunnyvale
        }
    }

    object Sunnyvale : Station() {
        override val displayName = "Sunnyvale Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sunnyvalestation-mobile.html")
        override val zone = Zone3
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Sunnyvale
            Southbound -> Lawrence
        }
    }

    object Lawrence : Station() {
        override val displayName = "Lawrence Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/lawrencestation-mobile.html")
        override val zone = Zone4
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Sunnyvale
            Southbound -> SantaClara
        }
    }

    object SantaClara : Station() {
        override val displayName = "Santa Clara Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/santaclarastation-mobile.html")
        override val zone = Zone4
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Lawrence
            Southbound -> CollegePark
        }
    }

    object CollegePark : Station() {
        override val displayName = "College Park Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/collegeparkstation-mobile.html")
        override val zone = Zone4
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SantaClara
            Southbound -> SanJoseDiridon
        }
    }

    object SanJoseDiridon : Station() {
        override val displayName = "San Jose Diridon Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanjosediridonstation-mobile.html")
        override val zone = Zone4
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> CollegePark
            Southbound -> Tamien
        }
    }

    object Tamien : Station() {
        override val displayName = "Tamien Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/tamienstation-mobile.html")
        override val zone = Zone4
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanJoseDiridon
            Southbound -> Capitol
        }

        override val weekdayCommuteOnly = true
    }

    object Capitol : Station() {
        override val displayName = "Capitol Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/capitolstation-mobile.html")
        override val zone = Zone5
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Tamien
            Southbound -> BlossomHill
        }

        override val weekdayCommuteOnly = true
    }

    object BlossomHill : Station() {
        override val displayName = "Blossom Hill Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/blossomhillstation-mobile.html")
        override val zone = Zone5
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> Capitol
            Southbound -> MorganHill
        }

        override val weekdayCommuteOnly = true
    }

    object MorganHill : Station() {
        override val displayName = "Morgan Hill Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/morganhillstation-mobile.html")
        override val zone = Zone6
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> BlossomHill
            Southbound -> SanMartin
        }

        override val weekdayCommuteOnly = true
    }

    object SanMartin : Station() {
        override val displayName = "San Martin Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanmartinstation-mobile.html")
        override val zone = Zone6
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> MorganHill
            Southbound -> Gilroy
        }

        override val weekdayCommuteOnly = true
    }

    object Gilroy : Station() {
        override val displayName = "Gilroy Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/gilroystation-mobile.html")
        override val zone = Zone6
        override fun nextInDirection(direction: Direction): Station? = when (direction) {
            Northbound -> SanMartin
            Southbound -> null
        }

        override val weekdayCommuteOnly = true
    }

    companion object {

        private val NORTHMOST_STATION = SanFrancisco
        private val NOT_LETTER = Regex("[^a-zA-Z0-9]")

        val STATIONS = generateSequence(NORTHMOST_STATION as Station) { it.nextInDirection(Southbound) }

        fun fromString(s: String): Station? =
            when (s.toLowerCase(Locale.US).replace(NOT_LETTER, "")) {
                "sanfrancisco" -> SanFrancisco
                "22ndstreet", "22ndst" -> TwentySecondStreet
                "bayshore" -> Bayshore
                "southsanfrancisco" -> SouthSanFrancisco
                "sanbruno" -> SanBruno
                "millbrae", "millbraetransitcenter" -> Millbrae
                "broadway" -> Broadway
                "burlingame" -> Burlingame
                "sanmateo" -> SanMateo
                "haywardpark" -> HaywardPark
                "hillsdale" -> Hillsdale
                "belmont" -> Belmont
                "sancarlos" -> SanCarlos
                "redwoodcity" -> RedwoodCity
                "atherton" -> Atherton
                "menlopark" -> MenloPark
                "paloalto" -> PaloAlto
                "californiaave" -> CaliforniaAve
                "sanantonio" -> SanAntonio
                "mountainview" -> MountainView
                "sunnyvale" -> Sunnyvale
                "lawrence" -> Lawrence
                "santaclara" -> SantaClara
                "collegepark" -> CollegePark
                "sanjosediridon" -> SanJoseDiridon
                "tamien" -> Tamien
                "capitol" -> Capitol
                "blossomhill" -> BlossomHill
                "morganhill" -> MorganHill
                "sanmartin" -> SanMartin
                "gilroy" -> Gilroy
                else -> null
            }

    }

}