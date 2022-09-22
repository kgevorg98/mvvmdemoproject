package com.example.demoprojectmvvm.data.di

import android.app.Application
import androidx.room.Room
import com.example.demoprojectmvvm.domain.repository.GalleryRepository
import com.example.demoprojectmvvm.data.dataservice.apiservice.GalleryService
import com.example.demoprojectmvvm.data.dataservice.sqlservice.GalleryDatabase
import com.example.demoprojectmvvm.data.repository.GalleryRepositoryImpl
import com.example.demoprojectmvvm.data.util.Constants.Companion.BASE_URL
import com.example.demoprojectmvvm.data.util.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .apply {
                client(
                    OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .build()
                )
            }
            .build()
    }

    single<GalleryService> { get<Retrofit>().create(GalleryService::class.java) }
}

val repositoryModule = module {
    single<GalleryRepository> { GalleryRepositoryImpl(get(), get(), get()) }
}

val databaseModule = module {
    fun provideDatabase(application: Application): GalleryDatabase {
        return Room.databaseBuilder(application, GalleryDatabase::class.java, "GalleryDatabase")
            .allowMainThreadQueries()
            .build()
    }
    single { provideDatabase(androidApplication()) }
    single { get<GalleryDatabase>().albumDao() }
    single { get<GalleryDatabase>().photoDao() }
}
