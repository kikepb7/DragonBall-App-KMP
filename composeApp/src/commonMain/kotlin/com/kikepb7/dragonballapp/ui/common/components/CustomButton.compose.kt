package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.ButtonHomePrimaryColor
import com.kikepb7.dragonballapp.ui.theme.TextButtonHomePrimaryColor

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier,
        onClick = onClick,
        colors = ButtonColors(
            containerColor = ButtonHomePrimaryColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextButtonHomePrimaryColor
        )
    }
}