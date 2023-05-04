package com.example.main.presentation.model

import com.example.domain.model.CurrentModel

data class CurrentUI(
    val condition: ConditionUI,
    val humidity: Int,
    val isDay: Int,
    val pressuremMb: Double,
    val tempC: Double,
    val tempF: Double,
    val windDegree: Int,
    val windKph: Double,
)

fun CurrentModel.toUI() = CurrentUI(
    condition = condition.toUI(),
    humidity = humidity,
    isDay = isDay,
    pressuremMb = pressuremMb,
    tempC = tempC,
    tempF = tempF,
    windDegree = windDegree,
    windKph = windKph
)