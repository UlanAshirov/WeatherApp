package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.LocationModel
import com.google.gson.annotations.SerializedName

data class LocationDto(
    val country: String,
    val name: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int
) : DataMapper<LocationModel> {
    override fun toDomain() = LocationModel(
        country = country,
        name = name,
        localtimeEpoch = localtimeEpoch
    )

}