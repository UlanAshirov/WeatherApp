package com.example.data.remote.repository

import com.example.common.Either
import com.example.data.base.makeNetworkRequest
import com.example.data.remote.apiservice.WeatherApiService
import com.example.domain.model.CurrentModel
import com.example.domain.model.ForecastdayModel
import com.example.domain.model.LocationModel
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl(
    private val api: WeatherApiService
) : WeatherRepository {
    override fun getWeather(cityName: String): Flow<Either<String, CurrentModel>> =
        makeNetworkRequest {
            api.getWeather(cityName).current.toDomain()
        }

    override fun getForecastWeather(cityName: String): Flow<Either<String, List<ForecastdayModel>>> =
        makeNetworkRequest {
            api.getWeather(cityName).forecast.forecastDay.map { it.toDomain() }
        }

    override fun getLocation(cityName: String): Flow<Either<String, LocationModel>> =
        makeNetworkRequest {
            api.getWeather(cityName = cityName).location.toDomain()
        }

}
