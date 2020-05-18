package com.example.marksweatherapp.UI.main

import com.example.marksweatherapp.UI.detail.DetailActivity
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
            current_temp_num.text = getString(R.string.current_metric)
            feels_like_num.text = getString(R.string.current_metric)
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
                current_temp_num.text = getString(R.string.current_imperial)
                feels_like_num.text = getString(R.string.current_imperial)
            }
            R.id.action_metric -> {
                useMetric = true
                current_temp_num.text = getString(R.string.current_metric)
                feels_like_num.text = getString(R.string.current_metric)
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
