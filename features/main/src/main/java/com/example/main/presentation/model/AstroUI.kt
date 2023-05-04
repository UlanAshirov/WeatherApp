package com.example.main.presentation.model

import com.example.domain.model.AstroModel

data class AstroUI(
    val isMoonUp: Int,
    val isSunUp: Int,
    val moonIllumination: String,
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)

fun AstroModel.toUI() = AstroUI(
    isMoonUp = isMoonUp,
    isSunUp = isSunUp,
    moonIllumination = moonIllumination,
    moonPhase = moonPhase,
    moonrise = moonrise,
    moonset = moonset,
    sunrise = sunrise,
    sunset = sunset
)