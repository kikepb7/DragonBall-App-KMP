package com.kikepb7.dragonballapp.ui.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.Black
import com.kikepb7.dragonballapp.ui.theme.Orange
import com.kikepb7.dragonballapp.ui.theme.Red
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconText(
    text: String,
    icon: DrawableResource,
    amount: String
) {
    Card(
        colors = CardDefaults.elevatedCardColors().copy(
            containerColor = Orange.copy(alpha = 0.45f)
        )
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Red,
            )
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Black
                )
                Text(
                    text = amount,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}