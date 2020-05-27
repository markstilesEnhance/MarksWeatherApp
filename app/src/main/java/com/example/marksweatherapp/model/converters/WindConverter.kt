package com.example.marksweatherapp.model.converters

object WindConverter {

    fun windConverter(deg: Int): String {
        return when(deg) {
            in 12..33 -> "NNE"
            in 34..56 -> "NE"
            in 57..78 -> "ENE"
            in 79..101 -> "E"
            in 102..123 -> "ESE"
            in 124..146 -> "SE"
            in 147..168 -> "SSE"
            in 169..191 -> "S"
            in 192..213 -> "SSW"
            in 214..236 -> "SW"
            in 237..258 -> "WSW"
            in 259..281 -> "W"
            in 282..303 -> "WNW"
            in 304..326 -> "NW"
            in 327..348 -> "NNW"
            else -> "N"
        }
    }

}