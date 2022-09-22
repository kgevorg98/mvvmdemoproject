package com.example.demoprojectmvvm.domain.repository

import com.example.demoprojectmvvm.core.Result
import com.example.demoprojectmvvm.domain.model.AlbumModel
import com.example.demoprojectmvvm.domain.model.PhotoModel
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {

     fun getAlbums(): Flow<Result<List<AlbumModel>>>

     fun getPhotos():Flow<Result<List<PhotoModel>>>
}