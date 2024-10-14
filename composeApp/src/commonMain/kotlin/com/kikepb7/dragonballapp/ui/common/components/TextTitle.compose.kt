package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.Black
import com.kikepb7.dragonballapp.ui.theme.Blue
import com.kikepb7.dragonballapp.ui.theme.Orange
import com.kikepb7.dragonballapp.ui.theme.TitleSectionFont

@Composable
fun TextTitle(text: String) {
    Box(Modifier.width(IntrinsicSize.Max)) {
        Box(
            Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(if (text.length < 3) 1f else 0.7f)
                .height(7.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Blue,
                            Blue.copy(alpha = 0f)
                        )
                    ),
                    shape = CircleShape
                )
        )
        Box(
            Modifier
                .align(Alignment.TopEnd)
                .fillMaxWidth(if (text.length < 3) 1f else 0.7f)
                .height(7.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Orange.copy(alpha = 0f),
                            Orange
                        )
                    ),
                    shape = CircleShape
                )
        )
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 1.dp),
            text = text.uppercase(),
            fontWeight = FontWeight.Bold,
            fontFamily = TitleSectionFont,
            fontSize = 24.sp,
            color = Black
        )
    }
}