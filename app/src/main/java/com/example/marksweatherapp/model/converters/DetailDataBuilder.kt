package com.example.marksweatherapp.model.converters

import com.example.marksweatherapp.model.classes.DetailData
import com.example.marksweatherapp.model.classes.MyDate
import com.example.marksweatherapp.model.classes.OpenWeatherResponse
import com.example.marksweatherapp.model.converters.HourlyConverter.hourlyConverter
import com.example.marksweatherapp.model.converters.DateConverter.dateConverter
import com.example.marksweatherapp.model.converters.TimeConverter.timeConverter

object DetailDataBuilder {

    fun detailDataBuilder(inputWeather: OpenWeatherResponse): MutableList<DetailData> {
        val output = mutableListOf<DetailData>()
        for(hour in inputWeather.hourly) {
            if(output.isEmpty() || timeConverter(hour.date, inputWeather.timezone_offset) == "12 AM") {
                output.add(MyDate(dateConverter(hour.date, inputWeather.timezone_offset)))
            }
            output.add(hourlyConverter(hour, inputWeather.timezone_offset))
        }
        return output
    }

}