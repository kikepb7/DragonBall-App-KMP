package com.kikepb7.dragonballapp.data.common

import com.kikepb7.dragonballapp.data.datasource.remote.dto.FailureDto
import com.kikepb7.dragonballapp.data.datasource.remote.feature.characters.dto.CharacterDto
import com.kikepb7.dragonballapp.domain.common.FailureDomain
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel

fun FailureDto.toFailureDomain(): FailureDomain {
    return when (this.code) {
        400 -> FailureDomain.UnknownHostError
        401 -> FailureDomain.Unauthorized
        else -> FailureDomain.ApiError
    }
}

fun List<CharacterDto>.dtoToCharactersListModel(): List<CharacterModel> {
    return this.map {
        it.dtoToCharacterModel()
    }
}
