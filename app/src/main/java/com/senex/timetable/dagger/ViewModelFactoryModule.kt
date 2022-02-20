package com.senex.timetable.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider

@Module
class ViewModelFactoryModule @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = providers[modelClass]
            ?: providers.entries.first {
                modelClass.isAssignableFrom(it.key)
            }.value

        return provider.get() as T
    }
}