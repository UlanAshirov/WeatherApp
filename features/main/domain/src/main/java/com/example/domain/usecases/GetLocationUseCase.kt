package com.example.domain.usecases

import com.example.domain.repository.WeatherRepository

class GetLocationUseCase(private val repository: WeatherRepository) {

    operator fun invoke(cityName: String) = repository.getLocation(cityName)
}