package com.example.demoprojectmvvm.data.dataservice.sqlservice

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demoprojectmvvm.data.model.room.AlbumEntity
import com.example.demoprojectmvvm.data.model.room.PhotoEntity

@Database(entities = [AlbumEntity::class, PhotoEntity::class], version = 1, exportSchema = false)
abstract class GalleryDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao
    abstract fun photoDao(): PhotoDao
}