package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.ConditionModel

data class ConditionDto(
    val code: Int,
    val icon: String,
    val text: String
) : DataMapper<ConditionModel> {
    override fun toDomain() = ConditionModel(
        code = code,
        icon = icon,
        text = text
    )

}