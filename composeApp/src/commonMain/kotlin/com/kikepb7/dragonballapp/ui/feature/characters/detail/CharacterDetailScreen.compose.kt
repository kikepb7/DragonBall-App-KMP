package com.kikepb7.dragonballapp.ui.feature.characters.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.domain.model.TransformationModel
import com.kikepb7.dragonballapp.ui.common.components.CustomFloatingActionButton
import com.kikepb7.dragonballapp.ui.common.components.TextTitle
import com.kikepb7.dragonballapp.ui.theme.BackGroundPrimaryColor
import com.kikepb7.dragonballapp.ui.theme.Black
import com.kikepb7.dragonballapp.ui.theme.CharacterDescriptionFont
import com.kikepb7.dragonballapp.ui.theme.CharacterDetailsFont
import com.kikepb7.dragonballapp.ui.theme.Orange
import com.kikepb7.dragonballapp.ui.theme.TextDescriptionColor
import dragonballapp.composeapp.generated.resources.Digit
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_dragon_ball_transformation
import dragonballapp.composeapp.generated.resources.radar_v2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
fun CharacterDetailScreen(
    characterModel: CharacterModel
) {
    val characterDetailViewModel = koinViewModel<CharacterDetailViewModel>()
    val characterDetailState by characterDetailViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = characterModel.id) {
        characterDetailViewModel.getCharacterDetail(characterId = characterModel.id.toString())
    }

    characterDetailState?.let { characterDetail ->
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        val bottomSheetState = rememberModalBottomSheetState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackGroundPrimaryColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                AsyncImage(
                    model = characterDetail.character?.originPlanetModel?.image,
                    contentDescription = "${characterDetail.character?.originPlanetModel?.name} image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                RadarKi(characterModel = characterModel)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    characterDetail.character?.characterModel?.let { MainCharacterDetail(characterModel = it) }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                characterDetail.character?.characterModel?.let { CharacterDetailInfo(characterModel = it) }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            CustomFloatingActionButton(
                icon = Res.drawable.ic_dragon_ball_transformation,
                onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
            )
        }

        if (bottomSheetState.isVisible) {
            characterDetail.character?.transformationModel?.let {
                CharacterTransformationBottomSheet(
                    characterName = characterModel.name,
                    coroutineScope = coroutineScope,
                    bottomSheetState = bottomSheetState,
                    transformationModel = it
                )
            }
        }
    }
}

@Composable
fun MainCharacterDetail(characterModel: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = characterModel.image,
            contentDescription = "${characterModel.name} image",
            modifier = Modifier
                .size(300.dp)
                .padding(top = 32.dp)
                .zIndex(1f),
            contentScale = ContentScale.Fit,
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = characterModel.race.uppercase(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = CharacterDetailsFont,
                color = Orange,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Text(
                text = characterModel.name.uppercase(),
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = CharacterDetailsFont,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
    }
}

@Composable
fun CharacterDetailInfo(characterModel: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        CharacterAffiliation(characterModel = characterModel)
        CharacterDescription(characterModel = characterModel)
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Gender: ${characterModel.gender}",
                color = Color.Black
            )
            Text(
                text = "Affiliation: ${characterModel.affiliation}",
                color = Color.Black
            )
        }
    }
}

@Composable
fun CharacterDescription(characterModel: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextTitle("DESCRIPTION")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = characterModel.description,
            fontSize = 14.sp,
            fontFamily = CharacterDescriptionFont,
            color = TextDescriptionColor,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun CharacterAffiliation(characterModel: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = characterModel.affiliation.uppercase(),
            fontSize = 42.sp,
            fontFamily = CharacterDetailsFont,
            fontWeight = FontWeight.Bold,
            color = Orange
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterTransformationBottomSheet(
    characterName: String,
    transformationModel: List<TransformationModel>,
    coroutineScope: CoroutineScope,
    bottomSheetState: SheetState
) {
    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch {
                bottomSheetState.hide()
            }
        },
        sheetState = bottomSheetState
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (transformationModel.isNotEmpty()) {
                TextTitle(text = "Transformations")

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(transformationModel) { transformation ->
                        Column(
                            modifier = Modifier
                                .width(250.dp)
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = transformation.image,
                                contentDescription = "${transformation.name} image",
                                modifier = Modifier
                                    .size(250.dp)
                                    .padding(top = 32.dp),
                                contentScale = ContentScale.Fit
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = transformation.name, style = MaterialTheme.typography.bodySmall)
                            Text(text = "Ki: ${transformation.ki}", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$characterName no tiene transformaciones",
                        fontFamily = CharacterDescriptionFont,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun RadarKi(characterModel: CharacterModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(Res.drawable.radar_v2),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer(alpha = 0.8f),
            contentDescription = "Radar Ki image"
        )

        Column(
            modifier = Modifier.padding(bottom = 40.dp, end = 20.dp)
        ) {
            Text(
                text = "MIN: ${characterModel.ki}",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(Res.font.Digit)),
                color = Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "MAX: ${characterModel.maxKi}",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(Res.font.Digit)),
                color = Black
            )
        }
    }
}
