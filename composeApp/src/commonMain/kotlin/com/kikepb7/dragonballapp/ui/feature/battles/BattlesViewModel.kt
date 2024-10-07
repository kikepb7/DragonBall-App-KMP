package com.kikepb7.dragonballapp.ui.feature.battles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.domain.feature.character.usecase.GetTwoRandomsCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BattlesViewModel(
    val getTwoRandomsCharactersUseCase: GetTwoRandomsCharactersUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(BattlesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getTwoRandomsCharactersUseCase()
            }

            _state.update { state ->
                state.copy(twoRandomCharacters = result)
            }
        }
    }
}

data class BattlesState(
    val twoRandomCharacters: List<CharacterModel>? = null
)