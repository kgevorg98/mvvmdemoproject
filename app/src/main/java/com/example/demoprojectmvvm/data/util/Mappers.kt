package com.example.demoprojectmvvm.data

import com.example.demoprojectmvvm.data.model.Album
import com.example.demoprojectmvvm.data.model.Photo
import com.example.demoprojectmvvm.data.model.room.AlbumEntity
import com.example.demoprojectmvvm.data.model.room.PhotoEntity
import com.example.demoprojectmvvm.domain.model.AlbumModel
import com.example.demoprojectmvvm.domain.model.PhotoModel

fun Album.toEntity(): AlbumEntity =
    AlbumEntity(
        id = id ?: -1,
        title = title ?: ""
    )

fun Photo.toEntity(): PhotoEntity =
    PhotoEntity(
        albumId = albumId ?: -1,
        id = id ?: -1,
        url = url ?: ""
    )

fun PhotoEntity.toDomain(): PhotoModel = PhotoModel(
    albumId = albumId,
    id = id,
    url = url
)

fun AlbumEntity.toDomain(): AlbumModel =
    AlbumModel(
        id = id,
        title = title
    )


