package com.kikepb7.dragonballapp.ui.feature.combats

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_placeholder
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

    Row {
        AsyncImage(
            model = characters?.first()?.characterModel?.image,
            contentDescription = "",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            modifier = Modifier.size(100.dp)
        )
        AsyncImage(
            model = characters?.get(1)?.characterModel?.image,
            contentDescription = "",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            modifier = Modifier.size(100.dp)
        )
    }

}

