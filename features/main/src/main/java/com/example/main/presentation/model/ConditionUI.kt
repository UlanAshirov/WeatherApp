package com.example.main.presentation.model

import com.example.domain.model.ConditionModel

data class ConditionUI(
    val code: Int,
    val icon: String,
    val text: String
)

fun ConditionModel.toUI() = ConditionUI(
    code = code,
    icon = icon,
    text = text
)