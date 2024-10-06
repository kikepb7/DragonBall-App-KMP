package com.kikepb7.dragonballapp.domain.feature.character.model

import com.kikepb7.dragonballapp.domain.model.OriginPlanetModel
import com.kikepb7.dragonballapp.domain.model.TransformationModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetailModel(
    val characterModel: CharacterModel,
    val originPlanetModel: OriginPlanetModel? = null,
    val transformationModel: List<TransformationModel>? = null
)
