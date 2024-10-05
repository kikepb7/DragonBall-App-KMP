package com.kikepb7.dragonballapp.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LinksDto(
    val first: String,
    val previous: String?,
    val next: String?,
    val last: String
)