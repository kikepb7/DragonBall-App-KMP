package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto

import com.kikepb7.dragonballapp.data.datasource.remote.dto.OriginPlanetDto
import com.kikepb7.dragonballapp.data.datasource.remote.dto.TransformationDto
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterDetailModel
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.domain.model.OriginPlanetModel
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
    val deletedAt: String? = null,
    val originPlanet: OriginPlanetDto? = null,
    val transformations: List<TransformationDto> = emptyList()
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

    fun dtoToCharacterDetailModel(): CharacterDetailModel {

        return CharacterDetailModel(
            characterModel = CharacterModel(
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
            ),
            originPlanetModel = originPlanet?.let {
                OriginPlanetModel(
                    id = it.id,
                    name = originPlanet.name,
                    isDestroyed = originPlanet.isDestroyed,
                    description = originPlanet.description,
                    image = originPlanet.image,
                    deletedAt = originPlanet.deletedAt
                )
            },
            transformationModel = transformations.map { it.dtoToTransformationModel() }
        )
    }
}