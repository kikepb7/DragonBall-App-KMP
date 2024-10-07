package com.kikepb7.dragonballapp.domain.feature.character.usecase

import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel

class GetTwoRandomsCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(): List<CharacterModel> {
        return getTwoRandomCharacters()
    }

    private suspend fun getTwoRandomCharacters(): List<CharacterModel> {
        val characters = characterRepository.getAllCharacters()
        return characters.shuffled().take(n = 2)
    }
}