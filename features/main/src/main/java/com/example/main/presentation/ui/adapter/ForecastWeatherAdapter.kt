package com.example.main.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core.ext.loadImage
import com.example.main.databinding.ItemForecastWeatherBinding
import com.example.main.presentation.model.ForecastdayUI
import java.text.DateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class ForecastWeatherAdapter :
    ListAdapter<ForecastdayUI, ForecastWeatherAdapter.ForecastWeatherViewHolder>(ForecastDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ForecastWeatherViewHolder(
        ItemForecastWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ForecastWeatherViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }

    class ForecastWeatherViewHolder(private val binding: ItemForecastWeatherBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: ForecastdayUI?) {
            binding.itemImgCondition.loadImage("https:${model?.day?.condition?.icon}")
            val unixTimestamp = model?.dateEpoch
            binding.itemTvDate.text = unixTimestamp?.toLong()?.let { formatUnixTimestamp(it) }
            binding.itemTvMaxTemp.text = "${model?.day?.maxTemp_c}°C"
            binding.itemTvMinTemp.text = "${model?.day?.minTemp_c}°C"
        }

        private fun formatUnixTimestamp(unixTimestamp: Long): String {
            val instant = Instant.ofEpochSecond(unixTimestamp)
            val formatter = DateTimeFormatter.ofPattern("MMMM, d", Locale.ENGLISH)
                .withZone(ZoneId.systemDefault())
            return formatter.format(instant)
        }
    }

    class ForecastDiffUtil : DiffUtil.ItemCallback<ForecastdayUI>() {
        override fun areItemsTheSame(oldItem: ForecastdayUI, newItem: ForecastdayUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ForecastdayUI, newItem: ForecastdayUI): Boolean =
            oldItem == newItem
    }
}