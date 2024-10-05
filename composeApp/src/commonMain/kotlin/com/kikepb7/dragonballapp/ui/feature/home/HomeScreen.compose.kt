package com.kikepb7.dragonballapp.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.ui.feature.characters.CharactersViewModel
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreenView(
    mainNavController: NavController
) {
    val characterViewModel = koinViewModel<CharactersViewModel>()
    val state by characterViewModel.state.collectAsStateWithLifecycle()


    Column {
        state?.characters?.let { CharactersGridList(characters = it) }
    }
}

@Composable
fun CharactersGridList(characters: List<CharacterModel>) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(horizontal = 16.dp),
        columns = GridCells.Fixed(count = 2),
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        items(count = characters.size) { position ->
            CharacterItemList(
                characterModel = characters[position],
                onItemSelected = {}
            )
        }
        /*when {
            characters?.refresh is LoadState.Loading && characters.itemCount == 0 -> {
                // Initial
                item(span = { GridItemSpan(currentLineSpan = 2) }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(size = 64.dp),
                            color = Color.Green
                        )
                    }
                }
            }

            characters?.loadState?.refresh is LoadState.NotLoading && characters.itemCount == 0 -> {
                // Empty list
                item {
                    Text(text = "No characters to show :/")
                }
            }

            else -> {
                characters?.itemCount?.let {
                    items(count = it) { position ->
                        characters[position]?.let { characterModel ->
                            CharacterItemList(
                                characterModel = characterModel,
                                onItemSelected = {}
                            )
                        }
                    }
                }
                if (characters?.loadState?.append is LoadState.Loading) {
                    item(span = { GridItemSpan(currentLineSpan = 2) }) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .height(100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(size = 64.dp),
                                color = Color.Green
                            )
                        }
                    }
                }
            }
        }*/
    }
}

@Composable
fun CharacterItemList(
    characterModel: CharacterModel,
    onItemSelected: (CharacterModel) -> Unit
) {
    CharacterCard(
        characterModel = characterModel,
        onItemSelected = onItemSelected,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun CharacterCard(
    characterModel: CharacterModel,
    onItemSelected: (CharacterModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(percent = 24))
            .border(
                width = 4.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(
                    topStartPercent = 0,
                    topEndPercent = 24,
                    bottomEndPercent = 0,
                    bottomStartPercent = 24
                )
            )
            .clickable { onItemSelected(characterModel) }
    ) {
        AsyncImage(
            model = characterModel.image,
            contentDescription = "Character image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            placeholder = painterResource(resource = Res.drawable.compose_multiplatform)
        )
        // NAME
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0f),
                            Color.Black.copy(alpha = 0.6f),
                            Color.Black.copy(alpha = 1f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = characterModel.name,
                color = Color.White,
                fontSize = 18.sp
            )
        }
        // GENDER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "Gender icon",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
