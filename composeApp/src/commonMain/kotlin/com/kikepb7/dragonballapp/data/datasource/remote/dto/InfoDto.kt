package com.kikepb7.dragonballapp.data.datasource.remote.dto

import com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto.CharacterDto
import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    val items: List<CharacterDto>,
    val meta: MetaDto,
    val links: LinksDto
)