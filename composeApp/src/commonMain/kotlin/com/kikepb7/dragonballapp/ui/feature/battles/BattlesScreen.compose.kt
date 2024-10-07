package com.kikepb7.dragonballapp.ui.feature.battles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.ui.common.components.CustomButton
import dragonballapp.composeapp.generated.resources.Res
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CharactersBattle(
            firstCharacterImage = characters?.first()?.image,
            secondCharacterImage = characters?.get(1)?.image
        )
        Spacer(modifier = Modifier.height(16.dp))
        CharactersBattleButtons(
            firstCharacterName = characters?.first()?.name,
            secondCharacterName = characters?.get(1)?.name,
            firstCharacterOption = {},
            secondCharacterOption = {}
        )
    }
}

@Composable
fun CharactersBattle(
    firstCharacterImage: String?,
    secondCharacterImage: String?
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = firstCharacterImage,
            contentDescription = "First character",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            modifier = Modifier.size(150.dp)
        )
        Image(
            painter = painterResource(resource = Res.drawable.ic_vs_logo),
            contentScale = ContentScale.Fit,
            contentDescription = "Versus logo",
            modifier = Modifier.size(100.dp)
        )
        AsyncImage(
            model = secondCharacterImage,
            contentDescription = "Second character",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun CharactersBattleButtons(
    firstCharacterName: String?,
    secondCharacterName: String?,
    firstCharacterOption: () -> Unit,
    secondCharacterOption: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (firstCharacterName != null) {
            CustomButton(text = firstCharacterName, onClick = firstCharacterOption)
        }
        if (secondCharacterName != null) {
            CustomButton(text = secondCharacterName, onClick = secondCharacterOption)
        }
    }
}
