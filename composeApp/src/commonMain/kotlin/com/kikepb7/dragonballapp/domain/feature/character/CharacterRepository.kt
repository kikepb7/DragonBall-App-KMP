package com.kikepb7.dragonballapp.domain.feature.character

import app.cash.paging.PagingData
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterModel>
}