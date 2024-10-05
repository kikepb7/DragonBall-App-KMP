package com.kikepb7.dragonballapp.data.datasource.remote.feature.characters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kikepb7.dragonballapp.data.datasource.remote.ApiService
import com.kikepb7.dragonballapp.domain.feature.character.model.CharacterModel

class CharacterPagingSource(
    private val api: ApiService
) : PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        TODO("Not yet implemented")
    }
}