package com.kikepb7.dragonballapp.ui.common.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_goku
import dragonballapp.composeapp.generated.resources.ic_planet
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource

sealed class Routes(val route: String) {
    data object Home: Routes("home")
    data object Characters: Routes("characters")
    data object Planets: Routes("planets")
    data object Battles: Routes("battles")
}

@Serializable
data class CharacterDetail(val characterModel: String)



sealed class ButtonHomeRoute {
    abstract val route: String
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    data class Characters(
        override val route: String = Routes.Characters.route,
        override val title: String = "CHARACTERS",
        override val icon: @Composable () -> Unit = {
            Icon(
                painter = painterResource(Res.drawable.ic_goku),
                contentDescription = "Characters icon",
                modifier = Modifier.size(32.dp)
            )
        }
    ): ButtonHomeRoute()

    data class Planets(
        override val route: String = Routes.Characters.route,
        override val title: String = "PLANETS",
        override val icon: @Composable () -> Unit = {
            Icon(
                painter = painterResource(Res.drawable.ic_planet),
                contentDescription = "Planets icon",
                modifier = Modifier.size(32.dp)
            )
        }
    ): ButtonHomeRoute()

    data class Battles(
        override val route: String = Routes.Battles.route,
        override val title: String = "COMBATS",
        override val icon: @Composable () -> Unit = {
            Icon(
                painter = painterResource(Res.drawable.ic_planet),
                contentDescription = "Combats icon",
                modifier = Modifier.size(32.dp)
            )
        }
    ): ButtonHomeRoute()
}