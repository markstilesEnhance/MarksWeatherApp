package com.example.marksweatherapp.UI

import com.example.marksweatherapp.R.drawable.*

object IconPicker {
    fun iconPicker(weather: String, time: String): Int {
        return when (weather) {
            "Sunny" -> ic_clear
            "Clear" -> ic_clear_night
            "Cloudy" -> ic_cloudy
            "Foggy" ->  ic_fog
            "Heavy Snow" -> ic_heavy_snow
            "Mostly Sunny" -> ic_mostly_clear
            "Mostly Clear" -> ic_mostly_clear_night
            "Mostly Cloudy" -> {if(time == "9 PM" || time == "10 PM" || time == "11 PM" ||
                time == "12 AM" || time == "1 AM" || time == "2 AM" || time == "3 AM" ||
                time == "4 AM" || time == "5 AM" || time == "6 AM")
            { ic_mostly_cloudy_night}
            else{ ic_mostly_cloudy }}
            "Partly Cloudy" -> {if(time == "9 PM" || time == "10 PM" || time == "11 PM" ||
                time == "12 AM" || time == "1 AM" || time == "2 AM" || time == "3 AM" ||
                time == "4 AM" || time == "5 AM" || time == "6 AM")
            { ic_partly_cloudy_night }
            else { ic_partly_cloudy }}
            "Rain" -> ic_rain
            "Showers" -> ic_showers
            "Snow Showers" -> ic_snow
            "Thunderstorm" -> ic_thunder
            "Windy" -> ic_wind
            "Wind and Rain" -> ic_wind_rain
            else -> ic_unknown
        }
    }
}