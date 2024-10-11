package com.kikepb7.dragonballapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import dragonballapp.composeapp.generated.resources.BebasNeue_Regular
import dragonballapp.composeapp.generated.resources.Outfit_VariableFont_wght
import dragonballapp.composeapp.generated.resources.ProtestStrike_Regular
import dragonballapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

val TitleSectionFont
    @Composable
    get() = FontFamily(Font(Res.font.BebasNeue_Regular))

val CharacterDescriptionFont
    @Composable
    get() = FontFamily(Font(Res.font.Outfit_VariableFont_wght))

val CharacterDetailsFont
    @Composable
    get() = FontFamily(Font(Res.font.ProtestStrike_Regular))