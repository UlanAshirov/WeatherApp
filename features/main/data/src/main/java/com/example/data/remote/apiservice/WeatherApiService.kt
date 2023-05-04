package com.example.data.remote.apiservice

import com.example.data.BuildConfig.API_KEY
import com.example.data.remote.dtos.BaseMainResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("forecast.json")
    suspend fun getWeather(
        @Query("q") cityName: String? = "",
        @Query("key") apiKey: String = API_KEY,
        @Query("days") days: Int = 7
    ): BaseMainResponse
}