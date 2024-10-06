package com.kikepb7.dragonballapp.di

import com.kikepb7.dragonballapp.ui.feature.characters.CharactersViewModel
import com.kikepb7.dragonballapp.ui.feature.combats.BattlesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CharactersViewModel)
    viewModelOf(::BattlesViewModel)
}