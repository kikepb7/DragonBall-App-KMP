package com.kikepb7.dragonballapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ButtonHomePrimaryColor
    @Composable
    get() = if (isSystemInDarkTheme()) BlueCard else LightOrange

val TextButtonHomePrimaryColor
    @Composable
    get() = if (isSystemInDarkTheme()) Orange else Blue

val IconButtonHomePrimaryColor
    @Composable
    get() = if (isSystemInDarkTheme()) Gray else Black

val BackGroundHomePrimaryColor
    @Composable
    get() = if (isSystemInDarkTheme()) DarkBlue else LightBlue


val Orange = Color(0xFFFF8C00)
val LightOrange = Color(0xFFFFC176)
val Red = Color(0xFFFF0000)
val Black = Color(0xFF01080A)
val Blue = Color(0xFF00008B)
val LightBlue = Color(0xC3DFE5FF)
val BlueCard = Color(0xC3101735)
val DarkBlue = Color(0xC300061D)
//val LightBlue = Color(0xFFADD8E6)
val Gray = Color(0xFFE7E5E8)
val Yellow = Color(0xFFFBBC42)
