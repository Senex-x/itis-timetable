package com.senex.timetable.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senex.timetable.presentation.ui.groups.GroupsViewModel
import com.senex.timetable.presentation.ui.schedule.ScheduleViewModel
import com.senex.timetable.presentation.ui.subject.SubjectViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GroupsViewModel::class)
    abstract fun bindGroupsViewModel(
        viewModel: GroupsViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    abstract fun bindScheduleViewModel(
        viewModel: ScheduleViewModel
    ): ViewModel
}