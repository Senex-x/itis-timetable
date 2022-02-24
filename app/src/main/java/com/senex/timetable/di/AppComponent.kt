package com.senex.timetable.di

import com.senex.timetable.ui.groups.GroupsFragment
import com.senex.timetable.ui.schedule.DailyScheduleFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    ViewModelsModule::class,
    DatabaseModule::class,
])
interface AppComponent {
    fun inject(dailyScheduleFragment: DailyScheduleFragment)

    fun inject(groupsFragment: GroupsFragment)
}