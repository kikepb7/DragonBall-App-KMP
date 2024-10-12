package com.kikepb7.dragonballapp.data.datasource.remote.feature.planets.repository

import com.kikepb7.dragonballapp.data.datasource.remote.ApiService
import com.kikepb7.dragonballapp.domain.feature.planet.PlanetRepository
import com.kikepb7.dragonballapp.domain.feature.planet.model.PlanetModel

class PlanetReporisotyImpl(
    private val api: ApiService,
) : PlanetRepository {

    override suspend fun getAllPlanets(): List<PlanetModel> {
        return api.getAllPlanets().items.map { planetDto -> planetDto.dtoToPlanedModel() }
    }
}