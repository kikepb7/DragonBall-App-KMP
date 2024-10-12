package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharactersWrapperDto(
    val items: List<CharacterDto>
)