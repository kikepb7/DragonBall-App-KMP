package com.kikepb7.dragonballapp.ui.common.navigation.bottomnavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kikepb7.dragonballapp.ui.common.navigation.Routes
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_goku
import dragonballapp.composeapp.generated.resources.ic_planet
import org.jetbrains.compose.resources.painterResource

sealed class BottomBarItem {
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
    ): BottomBarItem()

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
    ): BottomBarItem()

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
    ): BottomBarItem()
}