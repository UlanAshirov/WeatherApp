package com.example.domain.usecases

import com.example.domain.repository.WeatherRepository

class GetForecastWeatherUseCase(private val repository: WeatherRepository) {

    operator fun invoke(cityName: String) = repository.getForecastWeather(cityName)
}