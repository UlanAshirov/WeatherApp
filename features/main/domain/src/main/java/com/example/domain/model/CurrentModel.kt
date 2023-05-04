package com.example.domain.model

data class CurrentModel(
    val condition: ConditionModel,
    val humidity: Int,
    val isDay: Int,
    val pressuremMb: Double,
    val tempC: Double,
    val tempF: Double,
    val windDegree: Int,
    val windKph: Double,
)