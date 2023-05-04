package com.example.domain.repository

import com.example.common.Either
import com.example.domain.model.CurrentModel
import com.example.domain.model.DayModel
import com.example.domain.model.ForecastdayModel
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(cityName: String): Flow<Either<String, CurrentModel>>

    fun getForecastWeather(cityName: String): Flow<Either<String, List<ForecastdayModel>>>
}