package com.kikepb7.dragonballapp.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MetaDto(
    val totalItems: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalPages: Int,
    val currentPage: Int
)