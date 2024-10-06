package com.kikepb7.dragonballapp.data.datasource.remote.dto

import com.kikepb7.dragonballapp.domain.model.TransformationModel
import kotlinx.serialization.Serializable

@Serializable
data class TransformationDto(
    val id: Int,
    val name: String,
    val image: String,
    val ki: String,
    val deletedAt: String? = null
) {
    fun dtoToTransformationModel(): TransformationModel {
        return TransformationModel(
            id = id,
            name = name,
            image = image,
            ki = ki,
            deletedAt = deletedAt
        )
    }
}