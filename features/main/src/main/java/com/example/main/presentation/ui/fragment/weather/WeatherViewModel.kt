package com.example.main.presentation.ui.fragment.weather

import com.example.core.base.BaseViewModel
import com.example.domain.usecases.GetForecastWeatherUseCase
import com.example.domain.usecases.GetLocationUseCase
import com.example.domain.usecases.GetWeatherUseCase
import com.example.main.presentation.model.CurrentUI
import com.example.main.presentation.model.ForecastdayUI
import com.example.main.presentation.model.LocationUI
import com.example.main.presentation.model.toUI
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel
    (
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase,
    private val getLocationUseCase: GetLocationUseCase
) : BaseViewModel() {

    private val _weatherState = mutableUIStateFlow<CurrentUI>()
    val weatherState = _weatherState.asStateFlow()

    private val _forecastWeatherState = mutableUIStateFlow<List<ForecastdayUI>>()
    val forecastWeatherState = _forecastWeatherState.asStateFlow()

    private val _locationState = mutableUIStateFlow<LocationUI>()
    val locationState = _locationState.asStateFlow()

    fun getWeather(cityName: String) =
        getWeatherUseCase(cityName = cityName).gatherRequest(_weatherState) { it.toUI() }

    fun getForecastWeather(cityName: String) = getForecastWeatherUseCase(cityName)
        .gatherRequest(_forecastWeatherState) { forecastWeather -> forecastWeather.map { it.toUI() } }

    fun getLocation(cityName: String) = getLocationUseCase(cityName)
        .gatherRequest(_locationState) { it.toUI() }
}