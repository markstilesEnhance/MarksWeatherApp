package com.example.marksweatherapp.model.converters

import java.time.*

object TimeConverter {

    fun timeConverter(dt: Int, offset: Int): String {
        val now: LocalDateTime = LocalDateTime.ofEpochSecond((dt + offset).toLong(), 0, ZoneOffset.UTC)
        return when(now.hour) {
            0 -> "12 AM"
            in 1..11 -> "$now.hour AM"
            12 -> "12 PM"
            in 13..23 -> {
                val hour = now.hour - 12
                "$hour PM"
            }
            else -> "Error"
        }
    }

}