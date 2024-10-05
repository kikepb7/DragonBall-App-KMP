package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto

import com.kikepb7.dragonballapp.data.datasource.remote.dto.LinksDto
import com.kikepb7.dragonballapp.data.datasource.remote.dto.MetaDto
import kotlinx.serialization.Serializable

@Serializable
data class CharactersWrapperDto(
    val items: List<CharacterDto>
)