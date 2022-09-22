package com.example.demoprojectmvvm.domain.usecases

import com.example.demoprojectmvvm.domain.repository.GalleryRepository
import com.example.demoprojectmvvm.domain.interactors.GetPhotosInteractor
import com.example.demoprojectmvvm.domain.model.PhotoModel
import com.example.demoprojectmvvm.core.Result
import kotlinx.coroutines.flow.Flow

class GetPhotosUseCase(
    private val galleryRepository: GalleryRepository,
) : GetPhotosInteractor {
    override suspend fun invoke(): Flow<Result<List<PhotoModel>>> =
       galleryRepository.getPhotos()
}