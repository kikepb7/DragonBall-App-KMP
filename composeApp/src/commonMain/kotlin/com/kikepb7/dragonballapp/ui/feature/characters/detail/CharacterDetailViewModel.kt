package com.kikepb7.dragonballapp.ui.feature.characters.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterDetailModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val characterRepository: CharacterRepository
): ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailState())
    val state: StateFlow<CharacterDetailState?> = _state.asStateFlow()

    fun getCharacterDetail(characterId: String) {
        viewModelScope.launch {
            val character = characterRepository.getSingleCharacter(id = characterId)
            _state.update { state ->
                state.copy(character = character)
            }
        }
    }
}

data class CharacterDetailState(
    val character: CharacterDetailModel? = null
)