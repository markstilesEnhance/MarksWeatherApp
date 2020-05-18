package com.example.marksweatherapp.classes

//Holds each hourly forecast.  Does not include icon, that is determined by weather
data class Hourly(
    val time: String,
    val weather: String,
    val temp: Int,
    val feels: Int,
    val precip: Int,
    val windDir: String,
    val windSpeed: Int
): DetailData() {
    override val type = 1
}