package com.senex.timetable.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senex.timetable.presentation.groups.GroupsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactoryModule
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GroupsViewModel::class)
    abstract fun bindGroupsViewModel(
        viewModel: GroupsViewModel
    ): ViewModel
}