package com.example.demoprojectmvvm.presentation.utils

import android.view.View

fun View.show(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
    alpha = 1F
}


