package com.example.demoprojectmvvm.domain.model

import com.example.demoprojectmvvm.core.model.DiffUtilModel


data class AlbumModel(
    override val id: Int,
    val title: String

) : DiffUtilModel<Int>()
