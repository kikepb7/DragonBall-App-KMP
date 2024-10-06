package com.kikepb7.dragonballapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TransformationModel(
    val id: Int,
    val name: String,
    val image: String,
    val ki: String,
    val deletedAt: String? = null
)