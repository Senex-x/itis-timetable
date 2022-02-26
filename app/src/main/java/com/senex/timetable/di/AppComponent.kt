package com.senex.timetable.di

import com.senex.timetable.MainActivity
import com.senex.timetable.TimetableApplication
import com.senex.timetable.ui.groups.GroupsFragment
import com.senex.timetable.ui.schedule.daily.DailyScheduleFragment
import com.senex.timetable.ui.subject.SubjectFragment
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

    fun inject(subjectFragment: SubjectFragment)

    fun inject(app: TimetableApplication)
}