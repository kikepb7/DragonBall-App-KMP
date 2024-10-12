package com.kikepb7.dragonballapp.ui.feature.planets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil3.compose.AsyncImage
import com.kikepb7.dragonballapp.domain.feature.planet.model.PlanetModel
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_placeholder
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import kotlin.math.absoluteValue

@OptIn(KoinExperimentalAPI::class)
@Composable
fun PlanetScreenView() {
    val planetsViewModel = koinViewModel<PlanetsViewModel>()
    val state by planetsViewModel.state.collectAsState()

    Column(
    ) {
        state?.planets?.let { PlanetHorizontalPager(planetModel = it) }
    }
}

@Composable
fun PlanetHorizontalPager(planetModel: List<PlanetModel>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { planetModel.size })
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 65.dp),
            modifier = Modifier.height(200.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = (pagerState.currentPage - page + pagerState.currentPageOffsetFraction).absoluteValue
                        lerp(
                            start = 0.85f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        alpha = lerp(
                            start = 0.5f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    },
                shape = RoundedCornerShape(10.dp)
            ) {
                AsyncImage(
                    model = planetModel[page].image,
                    contentDescription = "Planet image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(resource = Res.drawable.ic_placeholder),
                    error = painterResource(resource = Res.drawable.ic_placeholder) // TODO --> Add error image
                )
            }
        }
    }
}