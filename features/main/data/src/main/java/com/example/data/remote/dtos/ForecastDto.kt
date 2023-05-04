package com.example.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday")
    val forecastDay: List<ForecastdayDto>
)