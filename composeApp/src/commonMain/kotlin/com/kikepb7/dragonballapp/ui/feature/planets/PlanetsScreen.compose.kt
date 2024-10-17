package com.kikepb7.dragonballapp.ui.feature.planets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.domain.feature.planet.model.PlanetModel
import com.kikepb7.dragonballapp.ui.common.extensions.aliveBorder
import com.kikepb7.dragonballapp.ui.theme.BackGroundPrimaryColor
import com.kikepb7.dragonballapp.ui.theme.BlueCard
import com.kikepb7.dragonballapp.ui.theme.CharacterDescriptionFont
import com.kikepb7.dragonballapp.ui.theme.CharacterDetailsFont
import com.kikepb7.dragonballapp.ui.theme.Orange
import com.kikepb7.dragonballapp.ui.theme.Red
import com.kikepb7.dragonballapp.ui.theme.TextDescriptionColor
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun PlanetsScreenView() {
    val planetsViewModel = koinViewModel<PlanetsViewModel>()
    val state by planetsViewModel.state.collectAsState()

    Column(modifier = Modifier.background(color = BackGroundPrimaryColor)) {
        state?.planets?.let { PlanetsLazyRow(items = it) }
    }
}

@Composable
fun PlanetsLazyRow(items: List<PlanetModel>) {
    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items, key = { item -> item.id }) { item ->
            Box(
                modifier = Modifier
                    .fillParentMaxSize()
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                PlanetItem(planetModel = item)
            }
        }
    }
}

@Composable
fun PlanetItem(planetModel: PlanetModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .size(205.dp)
                        .clip(shape = CircleShape)
                        .background(Color.Black.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = planetModel.image,
                        contentDescription = "${planetModel.name} image",
                        modifier = Modifier
                            .size(190.dp)
                            .clip(shape = CircleShape)
                            .aliveBorder(isAlive = planetModel.isDestroyed),
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = if (planetModel.isDestroyed) "ALIVE" else "DEAD",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(percent = 30))
                        .background(color = if (planetModel.isDestroyed) Green else Color.Red)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(BlueCard)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = planetModel.name,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = CharacterDetailsFont,
                        color = Orange,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = planetModel.description,
                        fontSize = 14.sp,
                        fontFamily = CharacterDescriptionFont,
                        color = TextDescriptionColor,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (planetModel.isDestroyed) "DESTRUIDO" else "EXISTE",
                        color = if (planetModel.isDestroyed) Red else Green,
                        fontFamily = CharacterDescriptionFont,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
