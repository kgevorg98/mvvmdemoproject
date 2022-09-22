package com.example.demoprojectmvvm.presentation.ui.gallery

import androidx.lifecycle.viewModelScope
import com.example.demoprojectmvvm.core.Result
import com.example.demoprojectmvvm.domain.interactors.GetAlbumsInteractor
import com.example.demoprojectmvvm.domain.interactors.GetPhotosInteractor
import com.example.demoprojectmvvm.domain.model.AlbumModel
import com.example.demoprojectmvvm.domain.model.PhotoModel
import com.example.demoprojectmvvm.presentation.appbase.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class GalleryViewModel(
    private val getAlbumsInteractor: GetAlbumsInteractor,
    private val getPhotosInteractor: GetPhotosInteractor
) : BaseViewModel() {
    private val _getAlbums: MutableStateFlow<MutableList<AlbumModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val getAlbums = _getAlbums.asStateFlow()

    private val _getPhotos: MutableStateFlow<MutableList<PhotoModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val getPhotos = _getPhotos.asStateFlow()

    init {
        getPhotos()

    }


    private fun getAlbums() = viewModelScope.launch {
        getAlbumsInteractor().onEach { result ->
            when (result) {
                is Result.Success -> {
                    _getAlbums.value = result.data?.toMutableList()
                }
                is Result.Error -> {

                }
                is Result.Loading -> {

                }
            }
        }.launchIn(this)
    }

    private fun getPhotos() = viewModelScope.launch {
        getPhotosInteractor().onEach { result ->
            when (result) {
                is Result.Success -> {
                    _getPhotos.value = result.data?.toMutableList()
                    getAlbums()
                }
                is Result.Error -> {

                }
                is Result.Loading -> {

                }
            }
        }.launchIn(this)
    }
}