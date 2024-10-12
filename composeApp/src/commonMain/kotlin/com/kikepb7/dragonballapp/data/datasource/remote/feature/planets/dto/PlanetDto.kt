package com.kikepb7.dragonballapp.data.datasource.remote.feature.planets.dto

import com.kikepb7.dragonballapp.domain.feature.planet.model.PlanetModel
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
    val deletedAll: String? = null
) {
    fun dtoToPlanedModel(): PlanetModel {
        return PlanetModel(
            id = id,
            name = name,
            isDestroyed = isDestroyed,
            description = description,
            image = image,
            deletedAll = deletedAll
        )
    }
}