package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.Orange

@Composable
fun CircularKiProgress(
    ki: String,
    maxKi: String
) {
    val kiValue = parseKiValue(ki = ki)
    val maxKiValue = parseKiValue(ki = maxKi)
    val progressSweepAngle = remember { Animatable(0f) }
    val progressText = remember { Animatable(0f) }

    LaunchedEffect(kiValue, maxKiValue) {
        val targetValue = (kiValue / maxKiValue).coerceIn(0f, 1f)

        progressSweepAngle.animateTo(
            targetValue = targetValue,
            animationSpec = tween(durationMillis = 3000)
        )

        progressText.animateTo(
            targetValue = kiValue,
            animationSpec = tween(durationMillis = 3000)
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier.size(90.dp)
        ) {
            Canvas(modifier = Modifier.size(90.dp)) {
                drawArc(
                    color = Color.LightGray,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(8.dp.toPx())
                )
                drawArc(
                    color = Orange,

                    startAngle = -90f,
                    sweepAngle = progressSweepAngle.value * 360f,
                    useCenter = false,
                    style = Stroke(8.dp.toPx())
                )
            }
            Text(
                text = "${(progressText.value * 10).toInt() / 10f}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
                color = Orange
            )
        }
        Box(
            modifier = Modifier.size(90.dp)
        ) {
            Canvas(modifier = Modifier.size(90.dp)) {
                drawArc(
                    color = Color.LightGray,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(8.dp.toPx())
                )
                drawArc(
                    color = Orange,

                    startAngle = -90f,
                    sweepAngle = progressSweepAngle.value * 360f,
                    useCenter = false,
                    style = Stroke(8.dp.toPx())
                )
            }
            Text(
                text = maxKi,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
                color = Orange
            )
        }
    }
}