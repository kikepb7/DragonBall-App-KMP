package com.kikepb7.dragonballapp.domain.feature.planet

import com.kikepb7.dragonballapp.domain.feature.planet.model.PlanetModel

interface PlanetRepository {
    suspend fun getAllPlanets(): List<PlanetModel>
}