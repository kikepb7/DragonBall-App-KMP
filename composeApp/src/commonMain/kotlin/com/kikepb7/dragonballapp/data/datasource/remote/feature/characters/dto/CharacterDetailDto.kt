package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto

//@Serializable
//data class CharacterDetailDto(
//    val id: Int,
//    val name: String,
//    val ki: String,
//    val maxKi: String,
//    val race: String,
//    val gender: String,
//    val description: String,
//    val image: String,
//    val affiliation: String,
//    val deletedAt: String? = null,
//    val originPlanet: OriginPlanetDto,
//    val transformations: List<TransformationDto> = emptyList()
//) {
//    fun dtoToCharacterDetailModel(): CharacterDetailModel {
//        return CharacterDetailModel(
//            id = id,
//            name = name,
//            ki = ki,
//            maxKi = maxKi,
//            race = race,
//            gender = gender,
//            description = description,
//            image = image,
//            affiliation = affiliation,
//            deletedAt = deletedAt,
//            originPlanet = originPlanet.dtoToOriginModel(),
//            transformations = transformations.map { it.dtoToTransformationModel() }
//        )
//    }
//}