package com.kikepb7.dragonballapp.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kikepb7.dragonballapp.ui.theme.ButtonHomePrimaryColor
import com.kikepb7.dragonballapp.ui.theme.IconButtonHomePrimaryColor
import com.kikepb7.dragonballapp.ui.theme.TextButtonHomePrimaryColor
import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.ic_goku
import dragonballapp.composeapp.generated.resources.ic_planet
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreenView(
    navigateToCharacters: () -> Unit,
    navigateToPlanets: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HomeOptionButton(
            text = "CHARACTERS",
            icon = Res.drawable.ic_goku,
            onClick = navigateToCharacters
        )
        Spacer(modifier = Modifier.height(16.dp))
        HomeOptionButton(
            text = "PLANETS",
            icon = Res.drawable.ic_planet,
            onClick = navigateToPlanets
        )
    }
}

@Composable
fun HomeOptionButton(
    text: String,
    icon: DrawableResource,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonColors(
            containerColor = ButtonHomePrimaryColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        )
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
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextButtonHomePrimaryColor
        )
    }
}

