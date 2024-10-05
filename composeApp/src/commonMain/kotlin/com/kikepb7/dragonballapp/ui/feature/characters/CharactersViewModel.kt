package com.kikepb7.dragonballapp.ui.feature.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersRepository: CharacterRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState?> = _state.asStateFlow()

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(characters = charactersRepository.getAllCharacters())
            }
        }
    }
}

data class CharactersState(
    val characters: List<CharacterModel> = emptyList()
)