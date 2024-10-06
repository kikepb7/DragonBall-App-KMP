package com.kikepb7.dragonballapp.ui.common.extensions

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kikepb7.dragonballapp.ui.theme.Yellow

fun Modifier.aliveBorder(isAlive: Boolean): Modifier {
    val color = if (isAlive) Yellow else Color.Red

    return border(4.dp, color, CircleShape)
}