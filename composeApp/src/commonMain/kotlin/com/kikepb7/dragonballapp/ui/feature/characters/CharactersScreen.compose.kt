package com.kikepb7.dragonballapp.ui.feature.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.ui.common.navigation.bottomnavigation.BottomBarItem.Battles
import com.kikepb7.dragonballapp.ui.common.navigation.bottomnavigation.BottomBarItem.Characters
import com.kikepb7.dragonballapp.ui.common.navigation.bottomnavigation.BottomBarItem.Planets
import com.kikepb7.dragonballapp.ui.theme.BackGroundPrimaryColor
import com.kikepb7.dragonballapp.ui.theme.Blue
import com.kikepb7.dragonballapp.ui.theme.Orange
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_placeholder
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersScreenView(
    mainNavController: NavHostController,
    navigateToDetail: (CharacterModel) -> Unit
) {
    val navController = rememberNavController()
    val items = listOf(Characters(), Battles(), Planets())
    val characterViewModel = koinViewModel<CharactersViewModel>()
    val state by characterViewModel.state.collectAsStateWithLifecycle()
    val listState = characterViewModel.scrollState.collectAsStateWithLifecycle().value

    Scaffold(
        topBar = {},
        bottomBar = {
//            BottomBarNavigation(
//                items = items,
//                navController = navController
//            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .background(color = BackGroundPrimaryColor)
        )
        {
            state?.characters?.let { CharactersGridList(characters = it, onItemSelected = navigateToDetail, listState = listState) }
        }

//        Box(
//            modifier = Modifier.padding(paddingValues = padding)
//        ) {
//            BottomNavigationWrapper(
//                navController = navController,
//                mainNavController = mainNavController
//            )
//        }
    }
}


@Composable
fun CharactersGridList(
    characters: List<CharacterModel>,
    listState: LazyGridState,
    onItemSelected: (CharacterModel) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        columns = GridCells.Fixed(count = 2),
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        items(count = characters.size) { position ->
            CharacterItemList(
                characterModel = characters[position],
                onItemSelected = { onItemSelected(it) }
            )
        }
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
                color = Blue,
                shape = RoundedCornerShape(
                    topStartPercent = 0,
                    topEndPercent = 24,
                    bottomEndPercent = 0,
                    bottomStartPercent = 24
                )
            )
            .background(color = Orange)
            .clickable { onItemSelected(characterModel) },
    ) {
        AsyncImage(
            model = characterModel.image,
            contentDescription = "Character image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            placeholder = painterResource(resource = Res.drawable.ic_placeholder)
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
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}