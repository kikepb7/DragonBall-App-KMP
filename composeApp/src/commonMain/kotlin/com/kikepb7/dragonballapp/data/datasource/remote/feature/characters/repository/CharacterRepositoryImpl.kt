package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.repository

import com.kikepb7.dragonballapp.data.datasource.remote.ApiService
import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterDetailModel
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel

class CharacterRepositoryImpl(
    private val api: ApiService,
) : CharacterRepository {

    override suspend fun getAllCharacters(): List<CharacterModel> {
        return api.getAllCharacters().items.map { characterDto -> characterDto.dtoToCharacterModel() }
    }

    override suspend fun getSingleCharacter(id: String): CharacterDetailModel {
        return api.getSingleCharacter(id = id).dtoToCharacterDetailModel()
    }
}