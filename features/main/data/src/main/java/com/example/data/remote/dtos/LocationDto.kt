package com.example.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class LocationDto(
    val country: String,
    val lat: Double,
    @SerializedName("localtime")
    val localTime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    @SerializedName("tz_id")
    val tzId: String
)