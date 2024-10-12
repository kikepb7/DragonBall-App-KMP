package com.kikepb7.dragonballapp.ui.feature.planets

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kikepb7.dragonballapp.domain.feature.planet.PlanetRepository
import com.kikepb7.dragonballapp.domain.feature.planet.model.PlanetModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlanetsViewModel(
    private val planetsRepository: PlanetRepository
): ViewModel() {
    private val _state = MutableStateFlow(PlanetsState())
    val state: StateFlow<PlanetsState?> = _state.asStateFlow()
    private val _scrollState = MutableStateFlow(LazyGridState())
    val scrollState: StateFlow<LazyGridState> = _scrollState

    init {
        getAllPlanets()
    }

    private fun getAllPlanets() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(planets = planetsRepository.getAllPlanets())
            }
        }
    }
}

data class PlanetsState(
    val planets: List<PlanetModel> = emptyList()
)