package com.example.demoprojectmvvm.domain.interactors

import com.example.demoprojectmvvm.core.Result
import com.example.demoprojectmvvm.domain.model.AlbumModel
import kotlinx.coroutines.flow.Flow

interface GetAlbumsInteractor {
    suspend operator fun invoke(): Flow<Result<List<AlbumModel>>>
}