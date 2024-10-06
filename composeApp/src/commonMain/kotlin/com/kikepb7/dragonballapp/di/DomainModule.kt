package com.kikepb7.dragonballapp.di

import com.kikepb7.dragonballapp.domain.feature.character.usecase.GetTwoRandomsCharactersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetTwoRandomsCharactersUseCase)
}