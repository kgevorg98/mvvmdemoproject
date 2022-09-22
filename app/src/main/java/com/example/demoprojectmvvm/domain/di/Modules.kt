package com.example.demoprojectmvvm.domain.di

import com.example.demoprojectmvvm.domain.interactors.GetAlbumsInteractor
import com.example.demoprojectmvvm.domain.interactors.GetPhotosInteractor
import com.example.demoprojectmvvm.domain.usecases.GetAlbumsUseCase
import com.example.demoprojectmvvm.domain.usecases.GetPhotosUseCase
import org.koin.dsl.module

val interactorModule = module {
    factory<GetAlbumsInteractor> {GetAlbumsUseCase(get())}
    factory<GetPhotosInteractor> {GetPhotosUseCase(get())}
}