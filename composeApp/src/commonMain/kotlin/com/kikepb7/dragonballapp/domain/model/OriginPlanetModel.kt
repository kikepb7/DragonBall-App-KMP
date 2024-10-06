package com.kikepb7.dragonballapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class OriginPlanetModel(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
    val deletedAt: String? = null
)