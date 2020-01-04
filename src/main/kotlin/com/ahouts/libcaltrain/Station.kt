package com.ahouts.libcaltrain

import com.ahouts.libcaltrain.Zone.*
import java.net.URL
import java.util.*

sealed class Station {

    abstract val displayName: String
    abstract val realtimeMobileUrl: URL
    abstract val zone: Zone
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

    object SanFrancisco : Station() {
        override val displayName = "San Francisco Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanfranciscostation-mobile.html")
        override val zone = Zone1
    }

    object TwentySecondStreet : Station() {
        override val displayName: String = "22nd Street Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/22ndstreetstation-mobile.html")
        override val zone = Zone1
    }

    object Bayshore : Station() {
        override val displayName: String = "Bayshore Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/bayshorestation-mobile.html")
        override val zone = Zone1
    }

    object SouthSanFrancisco : Station() {
        override val displayName: String = "South San Francisco Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/southsanfranciscostation-mobile.html")
        override val zone = Zone1
    }

    object SanBruno : Station() {
        override val displayName: String = "San Bruno Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanbrunostation-mobile.html")
        override val zone = Zone1
    }

    object Millbrae : Station() {
        override val displayName: String = "Millbrae Transit Center"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/millbraetransitcenter-mobile.html")
        override val zone = Zone2
    }

    object Broadway : Station() {
        override val displayName: String = "Broadway Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/broadwaystation-mobile.html")
        override val zone = Zone2
        override val weekendOnly = true
    }

    object Burlingame : Station() {
        override val displayName: String = "Burlingame Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/burlingamestation-mobile.html")
        override val zone = Zone2
    }

    object SanMateo : Station() {
        override val displayName = "San Mateo Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanmateostation-mobile.html")
        override val zone = Zone2
    }

    object HaywardPark : Station() {
        override val displayName = "Hayward Park Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/haywardparkstation-mobile.html")
        override val zone = Zone2
    }

    object Hillsdale : Station() {
        override val displayName = "Hillsdale Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/hillsdalestation-mobile.html")
        override val zone = Zone2
    }

    object Belmont : Station() {
        override val displayName = "Belmont Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/belmontstation-mobile.html")
        override val zone = Zone2
    }

    object SanCarlos : Station() {
        override val displayName = "San Carlos Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sancarlosstation-mobile.html")
        override val zone = Zone2
    }

    object RedwoodCity : Station() {
        override val displayName = "Redwood City Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/redwoodcitystation-mobile.html")
        override val zone = Zone2
    }

    object Atherton : Station() {
        override val displayName = "Atherton Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/athertonstation-mobile.html")
        override val zone = Zone3
        override val weekendOnly = true
    }

    object MenloPark : Station() {
        override val displayName = "Menlo Park Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/menloparkstation-mobile.html")
        override val zone = Zone3
    }

    object PaloAlto : Station() {
        override val displayName = "Palo Alto Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/paloaltostation-mobile.html")
        override val zone = Zone3
    }

    object CaliforniaAve : Station() {
        override val displayName = "California Ave. Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/californiaavestation-mobile.html")
        override val zone = Zone3
    }

    object SanAntonio : Station() {
        override val displayName = "San Antonio Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanantoniostation-mobile.html")
        override val zone = Zone3
    }

    object MountainView : Station() {
        override val displayName = "Mountain View Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/mountainviewstation-mobile.html")
        override val zone = Zone3
    }

    object Sunnyvale : Station() {
        override val displayName = "Sunnyvale Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sunnyvalestation-mobile.html")
        override val zone = Zone3
    }

    object Lawrence : Station() {
        override val displayName = "Lawrence Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/lawrencestation-mobile.html")
        override val zone = Zone4
    }

    object SantaClara : Station() {
        override val displayName = "Santa Clara Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/santaclarastation-mobile.html")
        override val zone = Zone4
    }

    object CollegePark : Station() {
        override val displayName = "College Park Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/collegeparkstation-mobile.html")
        override val zone = Zone4
    }

    object SanJoseDiridon : Station() {
        override val displayName = "San Jose Diridon Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanjosediridonstation-mobile.html")
        override val zone = Zone4
    }

    object Tamien : Station() {
        override val displayName = "Tamien Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/tamienstation-mobile.html")
        override val zone = Zone4
        override val weekdayCommuteOnly = true
    }

    object Capitol : Station() {
        override val displayName = "Capitol Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/capitolstation-mobile.html")
        override val zone = Zone5
        override val weekdayCommuteOnly = true
    }

    object BlossomHill : Station() {
        override val displayName = "Blossom Hill Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/blossomhillstation-mobile.html")
        override val zone = Zone5
        override val weekdayCommuteOnly = true
    }

    object MorganHill : Station() {
        override val displayName = "Morgan Hill Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/morganhillstation-mobile.html")
        override val zone = Zone6
        override val weekdayCommuteOnly = true
    }

    object SanMartin : Station() {
        override val displayName = "San Martin Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/sanmartinstation-mobile.html")
        override val zone = Zone6
        override val weekdayCommuteOnly = true
    }

    object Gilroy : Station() {
        override val displayName = "Gilroy Station"
        override val realtimeMobileUrl =
            URL("http://www.caltrain.com/schedules/realtime/stations/gilroystation-mobile.html")
        override val zone = Zone6
        override val weekdayCommuteOnly = true
    }

    companion object {

        fun fromString(s: String): Station? =
            when (s.toLowerCase(Locale.US)) {
                "sanfrancisco" -> SanFrancisco
                "22ndstreet" -> TwentySecondStreet
                "bayshore" -> Bayshore
                "southsanfrancisco" -> SouthSanFrancisco
                "sanbruno" -> SanBruno
                "millbrae" -> Millbrae
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