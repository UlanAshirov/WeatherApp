package com.example.main.presentation.model

import com.example.domain.model.ForecastdayModel

data class ForecastdayUI(
    val astro: AstroUI,
    val date: String,
    val dateEpoch: Int,
    val day: DayUI,
)

fun ForecastdayModel.toUI() = ForecastdayUI(
    astro = astro.toUI(),
    date = date,
    dateEpoch = dateEpoch,
    day = day.toUI()
)