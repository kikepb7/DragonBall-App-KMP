package com.kikepb7.dragonballapp.di

import com.kikepb7.dragonballapp.ui.feature.battles.BattlesViewModel
import com.kikepb7.dragonballapp.ui.feature.characters.CharactersViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CharactersViewModel)
    viewModelOf(::BattlesViewModel)
}