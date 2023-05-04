package com.example.domain.model

data class DayModel(
    val avgHumidity: Double,
    val avgTempC: Double,
    val avgVisKm: Double,
    val avgVis_miles: Double,
    val condition: ConditionModel,
    val maxTemp_c: Double,
    val maxWind_kph: Double,
    val minTemp_c: Double,
)