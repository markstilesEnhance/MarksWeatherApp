package com.example.marksweatherapp.model.converters

import com.example.marksweatherapp.model.classes.Hourly
import com.example.marksweatherapp.model.classes.HourlyResponse
import com.example.marksweatherapp.model.converters.TimeConverter.timeConverter
import com.example.marksweatherapp.model.converters.WindConverter.windConverter
import com.example.marksweatherapp.model.converters.WeatherConverter.weatherConverter
import kotlin.math.roundToInt

object HourlyConverter {

    fun hourlyConverter(input: HourlyResponse, offset: Int): Hourly {
        val time = timeConverter(input.date, offset)
        val temp = input.temperature.roundToInt()
        val weath = weatherConverter(input.weather[0].id, input.weather[0].icon, input.windSpeed)
        val windDir = windConverter(input.windDirection)
        val windSp = input.windSpeed.roundToInt()
        return Hourly(time, weath.first, temp, temp, 0, windDir, windSp, weath.second)
    }

}