package com.senex.timetable.dagger

import com.senex.timetable.data.models.schedule.Schedule
import com.senex.timetable.presentation.groups.GroupsFragment
import com.senex.timetable.presentation.schedule.ScheduleFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ViewModelFactoryModule::class,
    ViewModelsModule::class,
    ContextModule::class,
    PreferencesModule::class,
    DatabaseModule::class,
    RepositoryModule::class,
])
interface ApplicationComponent {
    fun inject(scheduleFragment: ScheduleFragment)

    fun inject(groupsFragment: GroupsFragment)
}