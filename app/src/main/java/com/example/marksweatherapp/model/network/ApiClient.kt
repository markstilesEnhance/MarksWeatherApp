package com.example.marksweatherapp.model.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {

    private var moshi: Moshi? = null
    private var okHttpClient: OkHttpClient? = null

    val client: Retrofit? get() {
        if(moshi == null) initMoshi()
        if(okHttpClient == null) initOkHttpClient()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun initOkHttpClient() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun initMoshi() {
        moshi = Moshi.Builder().build()
    }

}