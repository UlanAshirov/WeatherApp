package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.AstroModel
import com.google.gson.annotations.SerializedName

data class AstroDto(
    @SerializedName("is_moon_up")
    val isMoonUp: Int,
    @SerializedName("is_sun_up")
    val isSunUp: Int,
    @SerializedName("moon_illumination")
    val moonIllumination: String,
    @SerializedName("moon_phase")
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
) : DataMapper<AstroModel> {
    override fun toDomain() = AstroModel(
        isMoonUp = isMoonUp,
        isSunUp = isSunUp,
        moonIllumination = moonIllumination,
        moonPhase = moonPhase,
        moonrise = moonrise,
        moonset = moonset,
        sunrise = sunrise,
        sunset = sunset
    )
}