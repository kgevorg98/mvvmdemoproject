package com.example.demoprojectmvvm.domain.interactors


import com.example.demoprojectmvvm.core.Result
import com.example.demoprojectmvvm.domain.model.PhotoModel
import kotlinx.coroutines.flow.Flow

interface GetPhotosInteractor {
    suspend operator fun invoke(): Flow<Result<List<PhotoModel>>>
}