package com.example.domain.model

data class AstroModel(
    val isMoonUp: Int,
    val isSunUp: Int,
    val moonIllumination: String,
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)