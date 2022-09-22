package com.example.demoprojectmvvm.data.dataservice.sqlservice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demoprojectmvvm.data.model.room.AlbumEntity

@Dao
interface AlbumDao {

    @Query("SELECT * FROM albums")
    suspend fun getAllAlbums(): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbums(albums: List<AlbumEntity>)

}