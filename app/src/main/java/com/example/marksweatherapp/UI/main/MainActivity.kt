package com.example.marksweatherapp.UI.main

import UI.detail.DetailActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marksweatherapp.R
import com.example.marksweatherapp.network.TempData.hourlyForecasts
import kotlinx.android.synthetic.main.activity_main.*

//Weather icons taken from https://www.deviantart.com/merlinthered/art/plain-weather-icons-157162192
//Used with permission, CC-BY-SA

var useMetric = false

fun iconPicker(weather: String, time: String): Int {
    return when (weather) {
        "Sunny" -> R.drawable.ic_clear
        "Clear" -> R.drawable.ic_clear_night
        "Cloudy" -> R.drawable.ic_cloudy
        "Foggy" ->  R.drawable.ic_fog
        "Heavy Snow" -> R.drawable.ic_heavy_snow
        "Mostly Sunny" -> R.drawable.ic_mostly_clear
        "Mostly Clear" -> R.drawable.ic_mostly_clear_night
        "Mostly Cloudy" -> {if(time == "9 PM" || time == "10 PM" || time == "11 PM" ||
            time == "12 AM" || time == "1 AM" || time == "2 AM" || time == "3 AM" ||
            time == "4 AM" || time == "5 AM" || time == "6 AM")
        { R.drawable.ic_mostly_cloudy_night}
        else{ R.drawable.ic_mostly_cloudy }}
        "Partly Cloudy" -> {if(time == "9 PM" || time == "10 PM" || time == "11 PM" ||
            time == "12 AM" || time == "1 AM" || time == "2 AM" || time == "3 AM" ||
            time == "4 AM" || time == "5 AM" || time == "6 AM")
        { R.drawable.ic_partly_cloudy_night }
        else { R.drawable.ic_partly_cloudy }}
        "Rain" -> R.drawable.ic_rain
        "Showers" -> R.drawable.ic_showers
        "Snow Showers" -> R.drawable.ic_snow
        "Thunderstorm" -> R.drawable.ic_thunder
        "Windy" -> R.drawable.ic_wind
        "Wind and Rain" -> R.drawable.ic_wind_rain
        else -> R.drawable.ic_unknown
    }
}

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainListAdapter
    private lateinit var prefs: SharedPreferences
    private val METRIC_KEY = "metric"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("com.example.android.marksweatherapp", Context.MODE_PRIVATE)
        useMetric = prefs.getBoolean(METRIC_KEY, false)
        if(useMetric) {
            current_temp_num.text = "14°"
            feels_like_num.text = "14.5°"
        }

        initRecyclerView()

        details_button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        val prefsEditor = prefs.edit()
        prefsEditor.putBoolean(METRIC_KEY, useMetric)
        prefsEditor.apply()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_imperial -> {
                useMetric = false
                current_temp_num.text = "58°"
                feels_like_num.text = "58°"
            }
            R.id.action_metric -> {
                useMetric = true
                current_temp_num.text = "14°"
                feels_like_num.text = "14.5°"
            }
        }
        main_recycler.removeAllViews()
        initRecyclerView()
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView() {
        main_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = MainListAdapter(hourlyForecasts)
        main_recycler.adapter = adapter
    }

}
