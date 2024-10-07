package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CustomFloatingActionButton(
    icon: DrawableResource,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.size(64.dp)) {
        Icon(
            painter = painterResource(resource = icon),
            contentDescription = "Transformation button",
            modifier = Modifier
                .size(size = 64.dp)
                .clickable { onClick() },
            tint = Color.Unspecified
        )
    }
}