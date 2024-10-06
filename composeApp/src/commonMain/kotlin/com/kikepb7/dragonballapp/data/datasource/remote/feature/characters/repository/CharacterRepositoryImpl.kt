package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.repository

import com.kikepb7.dragonballapp.data.datasource.remote.ApiService
import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel

class CharacterRepositoryImpl(
    private val api: ApiService,
//    private val characterPagingSource: CharacterPagingSource
) : CharacterRepository {

    companion object {
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 5
    }
    override suspend fun getAllCharacters(): List<CharacterModel> {
        return api.getAllCharacters().items.map { characterDto -> characterDto.dtoToCharacterModel() }
    }

}