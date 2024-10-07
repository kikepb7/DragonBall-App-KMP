package com.kikepb7.dragonballapp.ui.feature.characters.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.ui.common.components.CustomFloatingActionButton
import com.kikepb7.dragonballapp.ui.common.components.IconText
import com.kikepb7.dragonballapp.ui.common.components.TextTitle
import com.kikepb7.dragonballapp.ui.theme.Orange
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_background_3
import dragonballapp.composeapp.generated.resources.ic_dragon_ball_transformation
import dragonballapp.composeapp.generated.resources.ic_empty_power
import dragonballapp.composeapp.generated.resources.ic_full_power
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    characterModel: CharacterModel
//    characterModel: CharacterDetailModel
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(resource = Res.drawable.ic_background_3),
                contentScale = ContentScale.Crop,
                contentDescription = "Background header"
            )
            CharacterPower(characterModel = characterModel)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                MainCharacterDetail(characterModel = characterModel)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            CharacterDetailInfo(characterModel = characterModel)
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
        CharacterTransformationBottomSheet(coroutineScope = coroutineScope, bottomSheetState = bottomSheetState, characterModel = characterModel)
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
                .size(250.dp)
                .padding(top = 32.dp),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = characterModel.race.uppercase(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Orange,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Text(
                text = characterModel.name.uppercase(),
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
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
        CharacterDescription(characterModel = characterModel)
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

@Composable
fun CharacterDescription(characterModel: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextTitle("DESCRIPTION")
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = characterModel.description,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun CharacterPower(characterModel: CharacterModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconText(text = "Base KI", icon = Res.drawable.ic_empty_power, amount = characterModel.ki)
        IconText(text = "Max KI", icon = Res.drawable.ic_full_power, amount = characterModel.maxKi)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterTransformationBottomSheet(
    characterModel: CharacterModel,
//    characterDetailModel: List<TransformationModel>,
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
//            LazyRow {
//                items(characterModel) { transformation ->
                    AsyncImage(
                        model = characterModel.image,
                        contentDescription = "${characterModel.name} image",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(top = 32.dp),
                        contentScale = ContentScale.Fit,
                    )
//                }
//            }
        }
    }
}
