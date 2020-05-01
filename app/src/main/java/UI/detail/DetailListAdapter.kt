package UI.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import classes.Date
import classes.DetailData
import classes.Hourly
import com.example.marksweatherapp.R
import com.example.marksweatherapp.UI.main.iconPicker
import com.example.marksweatherapp.UI.main.useMetric
import kotlinx.android.synthetic.main.detail_day_item.view.*
import kotlinx.android.synthetic.main.detail_hourly_item.view.*
import java.lang.ClassCastException
import java.math.BigDecimal
import java.math.RoundingMode

class DetailListAdapter(private var list: MutableList<DetailData>): Adapter<ViewHolder>() {

    class DetailHourlyViewHolder(itemView: View): ViewHolder(itemView) {
        fun bind(hourly: Hourly) {
            itemView.detail_hourly_time.text = hourly.time
            itemView.detail_hourly_image.setImageResource(iconPicker(hourly.weather, hourly.time))
            if(useMetric) {
                val metricTemp = BigDecimal((hourly.temp - 32) / 1.8).setScale(1, RoundingMode.CEILING)
                itemView.detail_hourly_temp.text = "$metricTemp"
                val metricWind = BigDecimal(hourly.windSpeed / 2.237).setScale(1, RoundingMode.CEILING)
                itemView.detail_hourly_wind.text = hourly.windDir + " $metricWind MPS"
            }
            else {
                itemView.detail_hourly_temp.text = "${hourly.temp}°"
                itemView.detail_hourly_wind.text = hourly.windDir + " ${hourly.windSpeed} MPH"
            }
            itemView.detail_hourly_precip.text = "${hourly.precip}%"
        }
    }

    class DetailDateViewHolder(itemView: View): ViewHolder(itemView) {
        fun bind(date: Date) {
            itemView.detail_day.text = date.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            1 -> DetailHourlyViewHolder(inflater.inflate(R.layout.detail_hourly_item, parent, false))
            2 -> return DetailDateViewHolder(inflater.inflate(R.layout.detail_day_item, parent, false))
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
                val dateItem = list[position] as Date
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