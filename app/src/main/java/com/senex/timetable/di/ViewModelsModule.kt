package com.senex.timetable.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senex.timetable.ui.groups.GroupsViewModel
import com.senex.timetable.ui.schedule.ScheduleViewModel
import com.senex.timetable.ui.subject.SubjectViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
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

    @Binds
    @IntoMap
    @ViewModelKey(SubjectViewModel::class)
    abstract fun bindSubjectViewModel(
        viewModel: SubjectViewModel
    ): ViewModel
}