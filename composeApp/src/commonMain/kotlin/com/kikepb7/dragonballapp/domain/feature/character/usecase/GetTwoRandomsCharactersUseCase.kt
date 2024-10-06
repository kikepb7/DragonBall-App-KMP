package com.kikepb7.dragonballapp.domain.feature.character.usecase

import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterDetailModel

class GetTwoRandomsCharactersUseCase(
    private val characterRepository: CharacterRepository
){
    suspend operator fun invoke(): List<CharacterDetailModel> {
        return generateTwoRandomsCharacters()
    }

    private suspend fun generateTwoRandomsCharacters(): List<CharacterDetailModel> {
        val firstRandomId: Int = (1..58).random()
        val secondRandomId: Int = (1..58).random()

        val firstRandomCharacter = characterRepository.getRandomCharacter(id = firstRandomId.toString())
        val secondRandomCharacter = characterRepository.getRandomCharacter(id = secondRandomId.toString())

        return listOf(firstRandomCharacter, secondRandomCharacter)
    }
}