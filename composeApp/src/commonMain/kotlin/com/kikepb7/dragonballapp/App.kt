package com.kikepb7.dragonballapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.kikepb7.dragonballapp.ui.common.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}