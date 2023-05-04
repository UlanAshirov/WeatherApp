package com.example.data.remote.dtos

data class BaseMainResponse(
    val current: CurrentDto,
    val forecast: ForecastDto,
    val location: LocationDto
)