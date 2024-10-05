package com.kikepb7.dragonballapp.di

import com.kikepb7.dragonballapp.data.datasource.remote.ApiService
import com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.repository.CharacterRepositoryImpl
import com.kikepb7.dragonballapp.domain.feature.character.CharacterRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(plugin = ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(plugin = DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "dragonball-api.com"
                }
            }
        }
    }

    factoryOf(::ApiService)
    factory<CharacterRepository> { CharacterRepositoryImpl(api = get()) }
}