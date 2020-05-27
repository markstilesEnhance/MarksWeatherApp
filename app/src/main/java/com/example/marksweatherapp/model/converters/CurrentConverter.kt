package com.example.marksweatherapp.model.converters

import com.example.marksweatherapp.model.classes.Current
import com.example.marksweatherapp.model.classes.CurrentResponse
import com.example.marksweatherapp.model.converters.WeatherConverter.weatherConverter
import kotlin.math.roundToInt

object CurrentConverter {

    fun currentConverter(input: CurrentResponse): Current {
        val weath = weatherConverter(input.weather[0].id, input.weather[0].icon, input.wind)
        return Current(input.temperature.roundToInt(), input.feels.roundToInt(), weath.second, weath.first)
    }

}