package com.example.main.presentation.model

import com.example.domain.model.DayModel

data class DayUI(
    val avgHumidity: Double,
    val avgTempC: Double,
    val avgVisKm: Double,
    val avgVis_miles: Double,
    val condition: ConditionUI,
    val maxTemp_c: Double,
    val maxWind_kph: Double,
    val minTemp_c: Double,
)

fun DayModel.toUI() = DayUI(
    avgHumidity = avgHumidity,
    avgTempC = avgTempC,
    avgVisKm = avgVisKm,
    avgVis_miles = avgVis_miles,
    condition = condition.toUI(),
    maxTemp_c = maxTemp_c,
    maxWind_kph = maxWind_kph,
    minTemp_c = minTemp_c
)