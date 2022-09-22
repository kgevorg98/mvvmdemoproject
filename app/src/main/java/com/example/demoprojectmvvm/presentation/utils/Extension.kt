package com.example.demoprojectmvvm.presentation.utils

import androidx.lifecycle.LifecycleOwner
import com.example.demoprojectmvvm.presentation.appbase.viewmodel.FlowObserver
import kotlinx.coroutines.flow.Flow

inline fun <reified T> Flow<T>.observeInLifecycle(
    lifecycleOwner: LifecycleOwner
) = FlowObserver(lifecycleOwner, this)