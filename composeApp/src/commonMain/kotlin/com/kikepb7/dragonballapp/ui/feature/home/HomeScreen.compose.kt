package com.kikepb7.dragonballapp.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.BackGroundHomePrimaryColor
import com.kikepb7.dragonballapp.ui.theme.ButtonHomePrimaryColor
import com.kikepb7.dragonballapp.ui.theme.IconButtonHomePrimaryColor
import com.kikepb7.dragonballapp.ui.theme.TextButtonHomePrimaryColor
import dragonballapp.composeapp.generated.resources.Outfit_VariableFont_wght
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_goku
import dragonballapp.composeapp.generated.resources.ic_planet
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreenView(
    navigateToCharacters: () -> Unit,
    navigateToPlanets: () -> Unit,
    navigateToBattles: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackGroundHomePrimaryColor)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Primera fila de botones
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(bottom = 16.dp) // Espacio entre filas
            ) {
                HomeOptionButton(
                    text = "CHARACTERS",
                    icon = Res.drawable.ic_goku,
                    onClick = navigateToCharacters
                )
                HomeOptionButton(
                    text = "PLANETS",
                    icon = Res.drawable.ic_planet,
                    onClick = navigateToPlanets
                )
            }
            // Segunda fila de botones
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeOptionButton(
                    text = "BATTLES",
                    icon = Res.drawable.ic_planet,
                    onClick = navigateToBattles
                )
            }
        }
    }
}

@Composable
fun HomeOptionButton(
    text: String,
    icon: DrawableResource,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(width = 160.dp, height = 120.dp)
            .clickable { onClick() },
        colors = CardColors(
            containerColor = ButtonHomePrimaryColor,
            contentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(resource = icon),
                    contentDescription = "Characters icon",
                    modifier = Modifier.size(32.dp),
                    tint = IconButtonHomePrimaryColor
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                Text(
                    text = text,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(Res.font.Outfit_VariableFont_wght)),
                    fontWeight = FontWeight.Bold,
                    color = TextButtonHomePrimaryColor
                )
            }
        }
    }
}

