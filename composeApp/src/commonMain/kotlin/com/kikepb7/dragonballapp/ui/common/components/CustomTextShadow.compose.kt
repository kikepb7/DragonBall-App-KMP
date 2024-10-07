package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.Blue
import com.kikepb7.dragonballapp.ui.theme.Orange

@Composable
fun CustomTextShadow(text: String) {
    CustomTextBase(
        text = text, style = TextStyle(
            color = Orange,
            shadow = Shadow(
                color = Blue, offset = Offset(x = 3f, y = 15f), blurRadius = 20f
            )
        )
    )
}

@Composable
fun CustomTextBase(text: String, style: TextStyle) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .drawWithCache {
                val brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF9E82F0),
                        Color(0xFF42A5F5)
                    )
                )
                onDrawBehind {
                    drawRoundRect(
                        brush,
                        cornerRadius = CornerRadius(10.dp.toPx())
                    )
                }
            },
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        ).merge(other = style)
    )
}