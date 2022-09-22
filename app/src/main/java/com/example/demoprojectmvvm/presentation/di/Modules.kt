package com.example.demoprojectmvvm.presentation.di

import com.example.demoprojectmvvm.presentation.ui.gallery.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GalleryViewModel(get(), get()) }
}