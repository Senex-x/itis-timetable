package com.senex.timetable.dagger

import com.senex.timetable.presentation.groups.GroupsFragment
import com.senex.timetable.presentation.schedule.ScheduleFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    ViewModelsModule::class,
    DatabaseModule::class,
])
interface AppComponent {
    fun inject(scheduleFragment: ScheduleFragment)

    fun inject(groupsFragment: GroupsFragment)
}