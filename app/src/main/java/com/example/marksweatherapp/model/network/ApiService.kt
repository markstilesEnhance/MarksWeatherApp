package com.example.marksweatherapp.model.network

import com.example.marksweatherapp.model.classes.OpenWeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("onecall?")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = "minutely,daily",
        @Query("units") units: String = "imperial",
        @Query("appid") appid: String
    ): Single<OpenWeatherResponse>

}