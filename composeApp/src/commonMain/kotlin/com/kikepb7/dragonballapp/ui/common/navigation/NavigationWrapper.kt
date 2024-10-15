package com.kikepb7.dragonballapp.ui.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.ui.feature.battles.BattlesScreen
import com.kikepb7.dragonballapp.ui.feature.characters.CharactersScreenView
import com.kikepb7.dragonballapp.ui.feature.characters.detail.CharacterDetailScreen
import com.kikepb7.dragonballapp.ui.feature.home.HomeScreenView
import com.kikepb7.dragonballapp.ui.feature.planets.PlanetsScreenView
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreenView(
                navigateToCharacters = { mainNavController.navigate(route = Routes.Characters.route) },
                navigateToPlanets = { mainNavController.navigate(route = Routes.Planets.route) },
                navigateToBattles = { mainNavController.navigate(route = Routes.Battles.route) }
            )
        }

        composable(route = Routes.Characters.route) {
            CharactersScreenView(
                mainNavController = mainNavController,
                navigateToDetail = { characterModel ->
                    val encode = Json.encodeToString(value = characterModel)
                    mainNavController.navigate(route = CharacterDetail(characterModel = encode))
                }
            )
        }

        composable<CharacterDetail> { navBackStackEntry ->
            val characterDetailEncoding = navBackStackEntry.toRoute<CharacterDetail>()
            val characterModel = Json.decodeFromString<CharacterModel>(string = characterDetailEncoding.characterModel)
            CharacterDetailScreen(characterModel = characterModel)
        }

        composable(route = Routes.Planets.route) {
            PlanetsScreenView()
        }

        composable(route = Routes.Battles.route) {
            BattlesScreen()
        }
    }
}
