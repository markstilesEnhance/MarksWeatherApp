package com.example.marksweatherapp.view.main

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.marksweatherapp.R
import com.example.marksweatherapp.model.converters.IconPicker.iconPicker
import com.example.marksweatherapp.model.classes.Hourly
import kotlinx.android.synthetic.main.main_hourly_item.view.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(hourly: Hourly) {
        val context: Context = itemView.context
        itemView.main_hourly_time.text = hourly.time
        if(useMetric) {
            val metricTemp = BigDecimal((hourly.temp - 32) / 1.8).setScale(1, RoundingMode.CEILING)
            itemView.main_hourly_temp.text = context.getString(R.string.degree_place, metricTemp)
        }
        else { itemView.main_hourly_temp.text = context.getString(R.string.degree_place, hourly.temp.toString()) }
        itemView.main_hourly_image.setImageResource(iconPicker(hourly.weather, hourly.time))
    }
}