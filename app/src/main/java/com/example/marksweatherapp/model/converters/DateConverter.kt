package com.example.marksweatherapp.model.converters

import java.time.*
import java.time.format.DateTimeFormatter

object DateConverter {

    fun dateConverter(dt: Int, offset: Int): String {
        val now: LocalDateTime = LocalDateTime.ofEpochSecond((dt + offset).toLong(), 0, ZoneOffset.UTC)
        val format = DateTimeFormatter.ofPattern("EEEE',' MMMM D")
        return now.format(format)
    }

}