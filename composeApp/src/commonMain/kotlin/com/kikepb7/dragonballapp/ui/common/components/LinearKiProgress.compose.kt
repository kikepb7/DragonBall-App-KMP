package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel
import com.kikepb7.dragonballapp.ui.theme.Gray
import com.kikepb7.dragonballapp.ui.theme.LightOrange
import com.kikepb7.dragonballapp.ui.theme.Orange

@Composable
fun KiPower(
    characterModel: CharacterModel,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                start = 12.dp,
                end = 12.dp
            )
    ) {
            /*Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text(
                    text = "Ki: ",
                    fontWeight = FontWeight.Bold
                )
                Text(text = characterModel.ki)
                KiProgress(characterModel.ki)
            }*/
        CircularKiProgress(ki = characterModel.ki, maxKi = characterModel.maxKi)
    }
}

@Composable
fun KiProgress(ki: String) {
    val gradient = Brush.linearGradient(listOf(LightOrange, Orange))
    val progressFactor = remember { Animatable(0f) }
    val maxKiProgress = 1_000_000_000f

    LaunchedEffect(ki) {
        val kiValue = parseKiValue(ki = ki)
        val targetValue = (kiValue / maxKiProgress).coerceIn(0f, 1f)

        progressFactor.animateTo(
            targetValue = targetValue,
            animationSpec = tween(durationMillis = 3000)
        )
    }

    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(12.dp)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(colors = listOf(Color.LightGray, Gray)),
                shape = RoundedCornerShape(size = 50.dp)
            )
            .clip(
                RoundedCornerShape(
                    topStartPercent = 50,
                    topEndPercent = 50,
                    bottomStartPercent = 50,
                    bottomEndPercent = 50
                )
            )
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(progressFactor.value)
                .background(brush = gradient),
            text = "",
            color = Color.White
        )
    }
}

fun parseKiValue(ki: String): Float {
    val sanitizedKi = ki.replace(".", "").trim()

    return when {
        sanitizedKi.endsWith("Billion", true) -> sanitizedKi.dropLast(7).toFloatOrNull()?.times(1_000_000_000f) ?: 0f
        sanitizedKi.endsWith("Trillion", true) -> sanitizedKi.dropLast(8).toFloatOrNull()?.times(1_000_000_000_000f) ?: 0f
        sanitizedKi.endsWith("Quadrillion", true) -> sanitizedKi.dropLast(11).toFloatOrNull()?.times(1_000_000_000_000_000f) ?: 0f
        sanitizedKi.endsWith("Quintillion", true) -> sanitizedKi.dropLast(11).toFloatOrNull()?.times(1_000_000_000_000_000_000f) ?: 0f
        sanitizedKi.endsWith("Septillion", true) -> sanitizedKi.dropLast(10).toFloatOrNull()?.times(1_000_000_000_000_000_000_000f) ?: 0f
        else -> sanitizedKi.toFloatOrNull() ?: 0f
    }
}