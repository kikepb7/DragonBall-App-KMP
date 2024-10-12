package com.kikepb7.dragonballapp.domain.feature.planet.model

import kotlinx.serialization.Serializable

@Serializable
data class PlanetModel(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
    val deletedAll: String? = null
)