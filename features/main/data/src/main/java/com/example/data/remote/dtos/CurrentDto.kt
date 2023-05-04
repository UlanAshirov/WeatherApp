package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.CurrentModel
import com.google.gson.annotations.SerializedName

data class CurrentDto(
    val condition: ConditionDto,
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("pressure_mb")
    val pressuremMb: Double,
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("temp_f")
    val tempF: Double,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_kph")
    val windKph: Double,
) : DataMapper<CurrentModel> {
    override fun toDomain() = CurrentModel(
        condition = condition.toDomain(),
        humidity = humidity,
        isDay = isDay,
        pressuremMb = pressuremMb,
        tempC = tempC,
        tempF = tempF,
        windDegree = windDegree,
        windKph = windKph
    )

}