package com.example.main.presentation.model

import com.example.domain.model.LocationModel

data class LocationUI(
    val country: String,
    val lat: Double,
    val localTime: String,
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tzId: String
)

fun LocationModel.toUI() = LocationUI(
    country = country,
    lat = lat,
    localTime = localTime,
    localtimeEpoch = localtimeEpoch,
    lon = lon,
    name = name,
    region = region,
    tzId = tzId
)