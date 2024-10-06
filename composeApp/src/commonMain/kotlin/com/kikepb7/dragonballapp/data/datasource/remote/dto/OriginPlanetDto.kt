package com.kikepb7.dragonballapp.data.datasource.remote.dto

import com.kikepb7.dragonballapp.domain.model.OriginPlanetModel
import kotlinx.serialization.Serializable

@Serializable
data class OriginPlanetDto(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
    val deletedAt: String? = null
) {
    fun dtoToOriginModel(): OriginPlanetModel {
        return OriginPlanetModel(
            id = id,
            name = name,
            isDestroyed = isDestroyed,
            description = description,
            image = image,
            deletedAt = deletedAt
        )
    }
}