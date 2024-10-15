package com.kikepb7.dragonballapp.ui.common.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kikepb7.dragonballapp.ui.common.navigation.CharacterDetail
import com.kikepb7.dragonballapp.ui.common.navigation.Routes
import com.kikepb7.dragonballapp.ui.feature.battles.BattlesScreen
import com.kikepb7.dragonballapp.ui.feature.characters.CharactersScreenView
import com.kikepb7.dragonballapp.ui.feature.planets.PlanetsScreenView
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun BottomNavigationWrapper(
    navController: NavHostController,
    mainNavController: NavHostController
) {
    // TODO --> fix startDestination, change by the one who choice
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(route = Routes.Characters.route) {
            CharactersScreenView(
                mainNavController = mainNavController,
                navigateToDetail = { characterModel ->
                    val encode = Json.encodeToString(value = characterModel)
                    mainNavController.navigate(route = CharacterDetail(characterModel = encode))
                }
            )
        }

        composable(route = Routes.Battles.route) {
            BattlesScreen()
        }

        composable(route = Routes.Planets.route) {
            PlanetsScreenView()
        }
    }
}