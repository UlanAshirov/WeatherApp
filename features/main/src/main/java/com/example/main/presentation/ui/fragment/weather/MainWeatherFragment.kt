package com.example.main.presentation.ui.fragment.weather

import android.os.Handler
import android.os.Looper
import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.core.ext.loadImage
import com.example.main.R
import com.example.main.databinding.FragmentMainWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainWeatherFragment :
    BaseFragment<FragmentMainWeatherBinding, WeatherViewModel>(R.layout.fragment_main_weather) {
    override val binding: FragmentMainWeatherBinding by viewBinding(FragmentMainWeatherBinding::bind)
    override val viewModel: WeatherViewModel by viewModel()
    private lateinit var runnable: Runnable
    private val handler = Handler(Looper.getMainLooper())


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

    private fun updateTimeUI(time: String) {
        binding.tvDatetime.text = time
    }

    private fun stopUpdatingTime() {
        handler.removeCallbacks(runnable)
    }

    override fun launchObservers() {
        getCurrentWeather()
        getForecatsWeather()
    }

    private fun getCurrentWeather() {
        viewModel.getWeather("Bishkek")
        viewModel.weatherState.spectateUiState(success = { currentWeather ->
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

    private fun getForecatsWeather() {
        viewModel.getForecastWeather("Bishkek")
        viewModel.forecastWeatherState.spectateUiState(success = { forecastWeather ->
            val maxTemp = forecastWeather.map { it.day.maxTemp_c.toString() }
            val minTemp = forecastWeather.map { it.day.minTemp_c.toString() }
            val sunset = forecastWeather.map { it.astro.sunset }
            val sunrise = forecastWeather.map { it.astro.sunrise }
            binding.tvMaxTemp.text = maxTemp[0]
            binding.tvMinTemp.text = minTemp[0]
            binding.tvSunset.text = sunset[0]
            binding.tvSunrise.text = sunrise[0]

        })
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