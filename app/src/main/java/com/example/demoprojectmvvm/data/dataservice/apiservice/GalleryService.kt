package com.example.demoprojectmvvm.data.dataservice.apiservice

import com.example.demoprojectmvvm.data.model.Album
import com.example.demoprojectmvvm.data.model.Photo
import retrofit2.http.GET

interface GalleryService {
    @GET("albums")
    suspend fun getAlbums():List<Album>

    @GET("photos")
    suspend fun getPhotos():List<Photo>
}