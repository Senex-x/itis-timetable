package com.senex.timetable.dagger

import com.senex.timetable.presentation.groups.GroupsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    ViewModelModule::class,
    DaggerViewModelFactoryModule::class,
    PreferencesModule::class,
])
interface ApplicationComponent {
    fun inject(groupsFragment: GroupsFragment)
}