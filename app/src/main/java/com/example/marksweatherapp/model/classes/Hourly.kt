package com.example.marksweatherapp.model.classes

//Holds each hourly forecast.  Does not include icon, that is determined by weather
data class Hourly(
    val time: String,
    val weather: String,
    val temp: Int,
    val feels: Int,
    val precip: Int,
    val windDir: String,
    val windSpeed: Int,
    val icon: Int = 0
): DetailData() {
    override val type = 1
}