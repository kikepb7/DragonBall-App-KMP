package com.kikepb7.dragonballapp.domain.feature.character

import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterDetailModel
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterModel>
    suspend fun getSingleCharacter(id: String): CharacterDetailModel
}