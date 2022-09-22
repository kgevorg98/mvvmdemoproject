package com.example.demoprojectmvvm.data.dataservice.sqlservice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demoprojectmvvm.data.model.room.PhotoEntity

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photos")
    fun getAllPhotos(): List<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos: List<PhotoEntity>)
}