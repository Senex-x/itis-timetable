package com.senex.timetable.dagger

import com.senex.timetable.presentation.groups.GroupsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface ApplicationComponent {
    fun inject(application: GroupsFragment)
}