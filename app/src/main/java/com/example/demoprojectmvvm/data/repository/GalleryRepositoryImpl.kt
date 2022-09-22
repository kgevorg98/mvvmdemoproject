package com.example.demoprojectmvvm.data.repository

import com.example.demoprojectmvvm.core.Result
import com.example.demoprojectmvvm.domain.repository.GalleryRepository
import com.example.demoprojectmvvm.data.dataservice.apiservice.GalleryService
import com.example.demoprojectmvvm.data.dataservice.sqlservice.AlbumDao
import com.example.demoprojectmvvm.data.dataservice.sqlservice.PhotoDao
import com.example.demoprojectmvvm.data.toDomain
import com.example.demoprojectmvvm.data.toEntity
import com.example.demoprojectmvvm.domain.model.AlbumModel
import com.example.demoprojectmvvm.domain.model.PhotoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GalleryRepositoryImpl(
    private val galleryService: GalleryService,
    private val photoDao: PhotoDao,
    private val albumDao: AlbumDao
) : GalleryRepository {
    override fun getAlbums(): Flow<Result<List<AlbumModel>>> = flow {
        emit(Result.Loading())
        val albums = albumDao.getAllAlbums().map { it.toDomain() }
        emit(Result.Loading(data = albums))
        try {
            val apiData = galleryService.getAlbums()
           // albumDao.deleteAlbums(apiData)
            albumDao.insertAlbums(apiData.map { it.toEntity() })
        } catch (e: HttpException) {
            emit(
                Result.Error(
                    message = "Try again",
                    data = albums
                )
            )
        } catch (e: IOException){
            emit(
                Result.Error(
                    message = "Check Internet Connection",
                    data = albums
                )
            )
        }
        val newAlbums = albumDao.getAllAlbums().map { it.toDomain() }
        emit(Result.Success(newAlbums))
    }


    override fun getPhotos(): Flow<Result<List<PhotoModel>>> = flow {
        emit(Result.Loading())
        val photos = photoDao.getAllPhotos().map { it.toDomain() }
        emit(Result.Loading(data = photos))
        try {
            val apiData = galleryService.getPhotos()
           // photoDao.deletePhotos(apiData)
            photoDao.insertPhotos(apiData.map { it.toEntity() })
        } catch (e: HttpException) {
            emit(
                Result.Error(
                    message = "Try again",
                    data = photos
                )
            )
        } catch (e: IOException){
            emit(
                Result.Error(
                    message = "Check Internet Connection",
                    data = photos
                )
            )
        }
        val newPhotos = photoDao.getAllPhotos().map { it.toDomain() }
        emit(Result.Success(newPhotos))
    }
}