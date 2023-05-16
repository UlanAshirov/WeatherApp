package com.example.main.presentation.ui.fragment.weather

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.core.ext.loadImage
import com.example.main.R
import com.example.main.databinding.FragmentMainWeatherBinding
import com.example.main.presentation.ui.adapter.ForecastWeatherAdapter
import com.example.main.presentation.ui.fragment.search.SearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class MainWeatherFragment :
    BaseFragment<FragmentMainWeatherBinding, WeatherViewModel>(R.layout.fragment_main_weather) {
    override val binding: FragmentMainWeatherBinding by viewBinding(FragmentMainWeatherBinding::bind)
    override val viewModel: WeatherViewModel by viewModel()
    private lateinit var runnable: Runnable
    private val handler = Handler(Looper.getMainLooper())
    private val adapter by lazy { ForecastWeatherAdapter() }
    private var city = ""
    override fun initialize() {
        binding.rvForecastWeather.adapter = adapter
        if (city.isEmpty()) {
            city = "Bishkek"
        }
    }

    override fun constructListeners() {
        binding.btnChangeCountry.setOnClickListener {
            SearchFragment(this::searchByNameCity).show(
                requireActivity().supportFragmentManager,
                ""
            )
        }
    }

    override fun launchObservers() {
        getCurrentWeather()
        getForecastWeather()
    }

    @SuppressLint("SetTextI18n")
    private fun getCurrentWeather() {
            viewModel.getWeather(city)

        viewModel.weatherState.spectateUiState(success = { currentWeather ->
            viewModel.getLocation(city)
            viewModel.locationState.spectateUiState(success = { locationData ->
                val city = locationData.name
                val country = locationData.country
                val locationFullName = " $city, $country"
                binding.btnChangeCountry.text = locationFullName
                binding.tvLocationTime.text =
                    formatUnixTimestamp(locationData.localtimeEpoch.toLong(), locationData.zoneId)
            })
            binding.tvTemp.text = currentWeather.tempC.toString()
            binding.imgCondition.loadImage("https:${currentWeather.condition.icon}")
            binding.tvCondition.text = currentWeather.condition.text
            binding.tvHumidity.text = "${currentWeather.humidity}%"
            binding.tvPressure.text = "${currentWeather.pressuremMb}mBar"
            binding.tvWindInKm.text = "${currentWeather.windKph}km/h"
        },
            error = { errorMsg ->
                Log.e("ololo", errorMsg)
            })
    }

    private fun getForecastWeather() {
        viewModel.getForecastWeather(city)
        viewModel.forecastWeatherState.spectateUiState(success = { forecastWeather ->
            val maxTemp = forecastWeather.map { it.day.maxTemp_c.toString() }
            val minTemp = forecastWeather.map { it.day.minTemp_c.toString() }
            val sunset = forecastWeather.map { it.astro.sunset }
            val sunrise = forecastWeather.map { it.astro.sunrise }
            binding.tvMaxTemp.text = maxTemp[0]
            binding.tvMinTemp.text = minTemp[0]
            binding.tvSunset.text = sunset[0]
            binding.tvSunrise.text = sunrise[0]
            adapter.submitList(forecastWeather)
        })
    }

    private fun startUpdatingTime() {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm:ss")
        runnable = object : Runnable {
            override fun run() {
                val currentTime = LocalDateTime.now()
                val formattedTime = formatter.format(currentTime)
                updateTimeUI(formattedTime)
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
    }

    fun formatUnixTimestamp(unixTimestamp: Long, zoneId: String): String {
        val instant = Instant.ofEpochSecond(unixTimestamp)
        val zonedDateTime = instant.atZone(ZoneId.of(zoneId))
        val formatter = DateTimeFormatter.ofPattern("HH'h' mm'm'", Locale.ENGLISH)
        return formatter.format(zonedDateTime)
    }

    private fun searchByNameCity(cityName: String) {
        city = cityName
        viewModel.getLocation(city)
        viewModel.getWeather(city)
        viewModel.getForecastWeather(city)
    }

    private fun updateTimeUI(time: String) {
        binding.tvDatetime.text = time
    }

    private fun stopUpdatingTime() {
        handler.removeCallbacks(runnable)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        startUpdatingTime()
    }

    override fun onPause() {
        super.onPause()
        stopUpdatingTime()
    }
}