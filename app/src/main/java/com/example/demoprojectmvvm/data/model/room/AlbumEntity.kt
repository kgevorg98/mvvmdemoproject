package com.example.demoprojectmvvm.data.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey val id:Int,
    val title:String
)