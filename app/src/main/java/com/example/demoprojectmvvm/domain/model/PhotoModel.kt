package com.example.demoprojectmvvm.domain.model

import com.example.demoprojectmvvm.core.model.DiffUtilModel

data class PhotoModel(
    val albumId: Int,
    override val id: Int,
    val url: String
):DiffUtilModel<Int>()
