package com.example.demoprojectmvvm.data.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoEntity(
    val albumId: Int,
    @PrimaryKey val id: Int,
    val url: String
)