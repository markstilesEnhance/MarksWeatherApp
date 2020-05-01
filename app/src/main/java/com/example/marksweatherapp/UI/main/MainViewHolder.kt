package com.example.marksweatherapp.UI.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import classes.Hourly
import kotlinx.android.synthetic.main.main_hourly_item.view.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(hourly: Hourly) {
        itemView.main_hourly_time.text = hourly.time
        itemView.main_hourly_precip.text = "${hourly.precip}%"
        if(useMetric) {
            val metricTemp = BigDecimal((hourly.temp - 32) / 1.8).setScale(1, RoundingMode.CEILING)
            itemView.main_hourly_temp.text = "$metricTemp°"
        }
        else { itemView.main_hourly_temp.text = "${hourly.temp}°" }
        itemView.main_hourly_image.setImageResource(iconPicker(hourly.weather, hourly.time))
    }
}