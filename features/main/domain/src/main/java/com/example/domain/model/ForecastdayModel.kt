package com.example.domain.model

data class ForecastdayModel(
    val astro: AstroModel,
    val date: String,
    val dateEpoch: Int,
    val day: DayModel,
)