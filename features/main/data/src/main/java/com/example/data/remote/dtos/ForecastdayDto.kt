package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.ForecastdayModel
import com.google.gson.annotations.SerializedName

data class ForecastdayDto(
    val astro: AstroDto,
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val day: DayDto,
) : DataMapper<ForecastdayModel> {
    override fun toDomain() = ForecastdayModel(
        astro = astro.toDomain(),
        date = date,
        dateEpoch = dateEpoch,
        day = day.toDomain()
    )
}