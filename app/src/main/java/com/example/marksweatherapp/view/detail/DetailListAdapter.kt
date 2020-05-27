package com.example.marksweatherapp.view.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.example.marksweatherapp.model.classes.MyDate
import com.example.marksweatherapp.model.classes.DetailData
import com.example.marksweatherapp.model.classes.Hourly
import com.example.marksweatherapp.R
import com.example.marksweatherapp.model.converters.IconPicker.iconPicker
import com.example.marksweatherapp.view.main.useMetric
import kotlinx.android.synthetic.main.detail_day_item.view.*
import kotlinx.android.synthetic.main.detail_hourly_item.view.*
import java.lang.ClassCastException
import java.math.BigDecimal
import java.math.RoundingMode

class DetailListAdapter(private var list: MutableList<DetailData>): Adapter<ViewHolder>() {

    class DetailHourlyViewHolder(itemView: View): ViewHolder(itemView) {
        fun bind(hourly: Hourly) {
            val context: Context = itemView.context
            itemView.detail_hourly_time.text = hourly.time
            itemView.detail_hourly_image.setImageResource(iconPicker(hourly.weather, hourly.time))
            if(useMetric) {
                val metricTemp = BigDecimal((hourly.temp - 32) / 1.8).setScale(1, RoundingMode.CEILING)
                itemView.detail_hourly_temp.text = context.getString(R.string.degree_place, metricTemp)
                val metricWind = BigDecimal(hourly.windSpeed / 2.237).setScale(1, RoundingMode.CEILING)
                itemView.detail_hourly_wind.text = context.getString(R.string.wind_place, hourly.windDir, metricWind, "MPS")
            } else {
                itemView.detail_hourly_temp.text = context.getString(R.string.degree_place, hourly.temp.toString())
                itemView.detail_hourly_wind.text = context.getString(R.string.wind_place, hourly.windDir, hourly.windSpeed.toString(), "MPH")
            }
        }
    }

    class DetailDateViewHolder(itemView: View): ViewHolder(itemView) {
        fun bind(myDate: MyDate) {
            itemView.detail_day.text = myDate.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            1 -> DetailHourlyViewHolder(
                inflater.inflate(R.layout.detail_hourly_item, parent, false)
            )
            2 -> return DetailDateViewHolder(
                inflater.inflate(R.layout.detail_day_item, parent, false)
            )
            else -> throw ClassCastException("Unknown Data Type")
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is DetailHourlyViewHolder -> {
                val hourlyItem = list[position] as Hourly
                holder.bind(hourlyItem)
            }
            is DetailDateViewHolder -> {
                val dateItem = list[position] as MyDate
                holder.bind(dateItem)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position].type) {
            1 -> 1
            2 -> 2
            else -> -1
        }
    }

}