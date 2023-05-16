package com.example.main.presentation.model

import com.example.domain.model.LocationModel

data class LocationUI(
    val country: String,
    val name: String,
    val localtimeEpoch: Int,
    val zoneId: String
)

fun LocationModel.toUI() = LocationUI(
    country = country,
    name = name,
    localtimeEpoch = localtimeEpoch,
    zoneId = zoneId
)