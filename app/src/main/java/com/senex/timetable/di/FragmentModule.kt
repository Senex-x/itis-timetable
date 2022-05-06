package com.senex.timetable.di

import com.senex.timetable.presentation.ui.groups.GroupsFragment
import com.senex.timetable.presentation.ui.schedule.ScheduleFragment
import com.senex.timetable.presentation.ui.schedule.daily.DailyScheduleFragment
import com.senex.timetable.presentation.ui.subject.ordinary.OrdinarySubjectFragment
import com.senex.timetable.presentation.ui.subject.varied.elective.ElectiveSubjectFragment
import com.senex.timetable.presentation.ui.subject.varied.elective.selectable.SelectableElectiveSubjectsFragment
import com.senex.timetable.presentation.ui.subject.varied.english.EnglishSubjectFragment
import com.senex.timetable.presentation.ui.subject.varied.english.selectable.SelectableEnglishSubjectsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeGroupsFragment(): GroupsFragment

    @ContributesAndroidInjector
    abstract fun contributeScheduleFragment(): ScheduleFragment

    @ContributesAndroidInjector
    abstract fun contributeDailyScheduleFragment(): DailyScheduleFragment

    @ContributesAndroidInjector
    abstract fun contributeOrdinarySubjectFragment(): OrdinarySubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeNewElectiveSubjectFragment(): ElectiveSubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeNewEnglishSubjectFragment(): EnglishSubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeNewSelectableElectiveSubjectsFragment(): SelectableElectiveSubjectsFragment

    @ContributesAndroidInjector
    abstract fun contributeNewSelectableEnglishSubjectsFragment(): SelectableEnglishSubjectsFragment
}