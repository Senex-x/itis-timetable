package com.senex.timetable.di

import com.senex.timetable.presentation.ui.groups.GroupsFragment
import com.senex.timetable.presentation.ui.schedule.daily.DailyScheduleFragment
import com.senex.timetable.presentation.ui.subject.elective.ElectiveSubjectFragment
import com.senex.timetable.presentation.ui.subject.ordinary.OrdinarySubjectFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeGroupsFragment(): GroupsFragment

    @ContributesAndroidInjector
    abstract fun contributeDailyScheduleFragment(): DailyScheduleFragment

    @ContributesAndroidInjector
    abstract fun contributeOrdinarySubjectFragment(): OrdinarySubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeElectiveSubjectFragment(): ElectiveSubjectFragment
}