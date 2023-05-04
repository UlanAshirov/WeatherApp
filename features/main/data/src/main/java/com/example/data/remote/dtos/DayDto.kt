package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.DayModel
import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("avghumidity")
    val avgHumidity: Double,
    @SerializedName("avgtemp_c")
    val avgTempC: Double,
    @SerializedName("avgvis_km")
    val avgVisKm: Double,
    @SerializedName("avgvis_miles")
    val avgVis_miles: Double,
    val condition: ConditionDto,
    @SerializedName("maxtemp_c")
    val maxTemp_c: Double,
    @SerializedName("maxwind_kph")
    val maxWind_kph: Double,
    @SerializedName("mintemp_c")
    val minTemp_c: Double,
) : DataMapper<DayModel> {
    override fun toDomain() = DayModel(
        avgHumidity = avgHumidity,
        avgTempC = avgTempC,
        avgVisKm = avgVisKm,
        avgVis_miles = avgVis_miles,
        condition = condition.toDomain(),
        maxTemp_c = maxTemp_c,
        maxWind_kph = maxWind_kph,
        minTemp_c = minTemp_c
    )
}