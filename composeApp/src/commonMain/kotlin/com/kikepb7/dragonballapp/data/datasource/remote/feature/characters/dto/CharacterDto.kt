package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto

import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String,
    val deletedAt: String? = null
//    val originPlanet: OriginDto ?= null,
//    val transformation: List<TransformationDto> = emptyList()
) {
    fun dtoToCharacterModel(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            ki = ki,
            maxKi = maxKi,
            race = race,
            gender = gender,
            description = description,
            image = image,
            affiliation = affiliation,
            deletedAt = deletedAt
        )
    }
}