package com.senex.timetable.di

import com.senex.timetable.ui.groups.GroupsFragment
import com.senex.timetable.ui.schedule.daily.DailyScheduleFragment
import com.senex.timetable.ui.subject.SubjectFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeGroupsFragment(): GroupsFragment

    @ContributesAndroidInjector
    abstract fun contributeDailyScheduleFragment(): DailyScheduleFragment

    @ContributesAndroidInjector
    abstract fun contributeSubjectFragment(): SubjectFragment
}