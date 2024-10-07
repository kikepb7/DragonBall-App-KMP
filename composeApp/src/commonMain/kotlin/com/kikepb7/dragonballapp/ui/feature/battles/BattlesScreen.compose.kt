package com.kikepb7.dragonballapp.ui.feature.battles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.ui.common.components.CustomTextShadow
import com.kikepb7.dragonballapp.ui.theme.Gray
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.battle_background
import dragonballapp.composeapp.generated.resources.ic_placeholder
import dragonballapp.composeapp.generated.resources.ic_vs_logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun BattlesScreen(
) {
    val battlesViewModel = koinViewModel<BattlesViewModel>()
    val state by battlesViewModel.state.collectAsState()
    val characters = state.twoRandomCharacters

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            CharactersBattleButtons(
                firstCharacterName = characters?.first()?.name,
                secondCharacterName = characters?.get(1)?.name
            )
        }
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(resource = Res.drawable.battle_background),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Background battle image"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CharactersBattle(
                firstCharacterImage = characters?.first()?.image,
                secondCharacterImage = characters?.get(1)?.image
            )
        }
    }
}

@Composable
fun CharactersBattle(
    firstCharacterImage: String?,
    secondCharacterImage: String?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = firstCharacterImage,
            contentDescription = "First character",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            modifier = Modifier
                .size(150.dp)
                .clickable {  }
        )
        AsyncImage(
            model = secondCharacterImage,
            contentDescription = "Second character",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            modifier = Modifier
                .size(150.dp)
                .clickable {  }
        )
    }
}

@Composable
fun CharactersBattleButtons(
    firstCharacterName: String?,
    secondCharacterName: String?,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        firstCharacterName?.let {
            CustomTextShadow(text = firstCharacterName)
        }
        Image(
            painter = painterResource(resource = Res.drawable.ic_vs_logo),
            contentScale = ContentScale.Fit,
            contentDescription = "Versus logo",
            modifier = Modifier.size(125.dp)
        )
        secondCharacterName?.let {
            CustomTextShadow(text = secondCharacterName)
        }
    }
}
