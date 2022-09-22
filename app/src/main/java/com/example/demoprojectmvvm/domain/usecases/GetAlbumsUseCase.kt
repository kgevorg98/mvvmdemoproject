package com.example.demoprojectmvvm.domain.usecases

import com.example.demoprojectmvvm.core.Result
import com.example.demoprojectmvvm.domain.repository.GalleryRepository
import com.example.demoprojectmvvm.domain.interactors.GetAlbumsInteractor
import com.example.demoprojectmvvm.domain.model.AlbumModel
import kotlinx.coroutines.flow.Flow

class GetAlbumsUseCase(
    private val galleryRepository: GalleryRepository,
) : GetAlbumsInteractor {
    override suspend fun invoke(): Flow<Result<List<AlbumModel>>> =
        galleryRepository.getAlbums()
}