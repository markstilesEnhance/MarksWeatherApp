package com.example.marksweatherapp.model.converters

import com.example.marksweatherapp.R.drawable.*

object WeatherConverter {

    fun weatherConverter(weather: Int, icon: String, wind: Double): Pair<String, Int> {
        val night = icon.contains('n')
        return when(weather) {
            in 200..232 -> Pair("Thunderstorms", ic_thunder)
            in 300..321 -> Pair("Showers", ic_showers)
            in 500..531 -> {
                if(weather == 511 && wind > 30) Pair("Freezing Rain", ic_wind_sleet)
                else if (weather == 511) Pair("Freezing Rain", ic_sleet)
                else if (wind > 30) Pair("Rainstorm", ic_wind_rain)
                else Pair("Rain", ic_rain)
            }
            in 600..601 -> {
                if(wind > 30) Pair("Snow", ic_wind_snow)
                else Pair("Snow", ic_snow)
            }
            602 -> {
                if(wind > 30) Pair("Blizzard", ic_wind_snow)
                else Pair("Snow", ic_heavy_snow)
            }
            in 611..613 -> {
                if(wind > 30) Pair("Sleet", ic_wind_sleet)
                else Pair("Sleet", ic_sleet)
            }
            in 615..622 -> Pair("Winter Mix", ic_rain_snow)
            701 -> Pair("Mist", ic_fog)
            711 -> Pair("Smoke", ic_fog)
            721 -> Pair("Haze", ic_fog)
            731, 751, 761 -> Pair("Dust", ic_fog)
            741 -> Pair("Fog", ic_fog)
            762 -> Pair("Volcanic Ash", ic_warning)
            771 -> Pair("Squall", ic_fog)
            781 -> Pair("Tornado", ic_warning)
            800 -> {
                if(night) Pair("Clear", ic_clear_night)
                else Pair("Sunny", ic_clear)
            }
            801 -> {
                if(night) Pair("Mostly Clear", ic_mostly_clear_night)
                else Pair("Mostly Sunny", ic_mostly_clear)
            }
            802 -> {
                if(night) Pair("Partly Cloudy", ic_partly_cloudy_night)
                else Pair("Partly Cloudy", ic_partly_cloudy)
            }
            in 803..804 -> {
                if(night) Pair("Mostly Cloudy", ic_mostly_cloudy_night)
                else Pair("Mostly Cloudy", ic_mostly_cloudy)
            }
            else -> Pair("Unknown", ic_unknown)
        }
    }

}