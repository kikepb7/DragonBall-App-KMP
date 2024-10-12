package com.kikepb7.dragonballapp.data.datasource.remote

import com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto.CharacterDto
import com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto.CharactersWrapperDto
import com.kikepb7.dragonballapp.data.datasource.remote.feature.planets.dto.PlanetsWrapperDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    private val httpClient: HttpClient
) {

    // CHARACTERS
    suspend fun getSingleCharacter(id: String): CharacterDto {
        return httpClient.get("/api/characters/$id").body()
    }

    suspend fun getAllCharacters(): CharactersWrapperDto {
        return httpClient.get("/api/characters") {
            parameter(key = "limit", value = 60)
        }.body()
    }

    // PLANETS
    suspend fun getAllPlanets(): PlanetsWrapperDto {
        return httpClient.get("/api/planets") {
            parameter(key = "limit", value = 20)
        }.body()
    }
}