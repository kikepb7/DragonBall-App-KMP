package com.kikepb7.dragonballapp.data.datasource.remote.feature.planets.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlanetsWrapperDto(
    val items: List<PlanetDto>
)