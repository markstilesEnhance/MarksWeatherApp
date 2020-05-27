package com.example.marksweatherapp.model.classes

import com.squareup.moshi.Json

data class OpenWeatherResponse (

    @Json(name = "timezone_offset")
    val timezone_offset: Int,

    @Json(name = "current")
    val current: CurrentResponse,

    @Json(name = "hourly")
    val hourly: MutableList<HourlyResponse>
)

data class CurrentResponse (

    @Json(name = "temp")
    val temperature: Double,

    @Json(name = "feels_like")
    val feels: Double,

    @Json(name = "wind_speed")
    val wind: Double,

    @Json(name = "weather")
    val weather: MutableList<WeatherResponse>
)

data class HourlyResponse (

    @Json(name = "dt")
    val date: Int,

    @Json(name = "temp")
    val temperature: Double,

    @Json(name = "wind_speed")
    val windSpeed: Double,

    @Json(name = "wind_deg")
    val windDirection: Int,

    @Json(name = "weather")
    val weather: MutableList<WeatherResponse>
)

data class WeatherResponse (

    @Json(name = "id")
    val id: Int,

    @Json(name = "icon")
    val icon: String
)