package com.senex.timetable.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

typealias ViewModelsProvidersMap =
        Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

class ViewModelFactory @Inject constructor(
    private val providers: ViewModelsProvidersMap,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        providers.getValue(modelClass).get() as T
}