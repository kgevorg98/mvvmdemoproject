package com.example.demoprojectmvvm

import android.app.Application
import android.content.Context
import com.example.demoprojectmvvm.data.di.apiModule
import com.example.demoprojectmvvm.data.di.databaseModule
import com.example.demoprojectmvvm.data.di.repositoryModule
import com.example.demoprojectmvvm.domain.di.interactorModule
import com.example.demoprojectmvvm.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(modules)
            androidLogger()
            androidContext(this@App)}
    }

    private val modules = listOf(
        apiModule,
        repositoryModule,
        interactorModule,
        viewModelModule,
        databaseModule
    )
}