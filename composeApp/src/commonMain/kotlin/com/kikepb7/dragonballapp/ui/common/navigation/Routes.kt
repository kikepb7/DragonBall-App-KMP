package com.kikepb7.dragonballapp.ui.common.navigation

import kotlinx.serialization.Serializable

sealed class Routes(val route: String) {
    data object Home: Routes("home")
    data object Characters: Routes("characters")
    data object Planets: Routes("planets")
    data object Battles: Routes("battles")
}

@Serializable
data class CharacterDetail(val characterModel: String)