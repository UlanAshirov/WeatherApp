package com.example.domain.usecases

import com.example.domain.repository.WeatherRepository

class GetWeatherUseCase(private val repository: WeatherRepository) {
    operator fun invoke(cityName: String) = repository.getWeather(cityName = cityName)
}