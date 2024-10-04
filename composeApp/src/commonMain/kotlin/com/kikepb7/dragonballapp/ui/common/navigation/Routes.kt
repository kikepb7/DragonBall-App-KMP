package com.kikepb7.dragonballapp.ui.common.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")

    data object Characters : Routes("characters")
}