package com.kikepb7.dragonballapp.data.datasource.remote

import com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto.CharactersWrapperDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    private val httpClient: HttpClient
) {

    // CHARACTERS
    suspend fun getAllCharacters(): CharactersWrapperDto {
        return httpClient.get("/api/characters") {
            parameter(key = "limit", value = 60)
        }.body()
    }

    /*suspend fun getAllCharacters(page: Int, limit: Int): CharactersWrapperDto {
        return httpClient.get("/api/characters") {
            parameter(key = "page", value = page)
            parameter(key = "limit", value = limit)
        }.body()
    }*/
}