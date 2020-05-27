package com.example.marksweatherapp.model.converters

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

    fun iconPicker(weather: Int, icon: String, wind: Double): Int {
        val night = icon.contains('n')
        return when(weather) {
            in 200..299 -> ic_thunder
            in 300..399 -> ic_showers
            in 500..599 -> {
                if(weather == 511 && wind > 30) {
                    ic_wind_sleet}
                else if(weather == 511) {
                    ic_sleet}
                else if(wind > 30) {
                    ic_wind_rain}
                else {
                    ic_rain}
                }
            in 600..602 -> {
                if(wind > 30) {
                    ic_wind_snow}
                else if(weather == 602) {
                    ic_heavy_snow}
                else {
                    ic_snow}
            }
            in 611..613 -> {
                if(wind > 30) {
                    ic_wind_sleet}
                else { ic_sleet}
            }
            in 615..699 -> ic_rain_snow
            in 701..799 -> ic_fog
            800 -> {
                if(night) {
                    ic_clear_night}
                else {
                    ic_clear}
            }
            801 -> {
                if(night) {
                    ic_mostly_clear_night}
                else {
                    ic_mostly_clear}
            }
            802 -> {
                if(night) {
                    ic_partly_cloudy_night}
                else {
                    ic_partly_cloudy}
            }
            in 803..804 -> {
                if(night) {
                    ic_mostly_cloudy_night}
                else {
                    ic_mostly_cloudy}
            }
            else -> ic_unknown
        }
    }

}