package com.senex.timetable.di

import com.senex.timetable.presentation.ui.groups.GroupsFragment
import com.senex.timetable.presentation.ui.schedule.ScheduleFragment
import com.senex.timetable.presentation.ui.schedule.daily.DailyScheduleFragment
import com.senex.timetable.presentation.ui.subject.elective.ElectiveSubjectFragment
import com.senex.timetable.presentation.ui.subject.elective.selectable.SelectableElectiveSubjectsFragment
import com.senex.timetable.presentation.ui.subject.english.EnglishSubjectFragment
import com.senex.timetable.presentation.ui.subject.english.selectable.SelectableEnglishSubjectsFragment
import com.senex.timetable.presentation.ui.subject.ordinary.OrdinarySubjectFragment
import com.senex.timetable.presentation.ui.subject.varied.NewElectiveSubjectFragment
import com.senex.timetable.presentation.ui.subject.varied.NewEnglishSubjectFragment
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
    abstract fun contributeElectiveSubjectFragment(): ElectiveSubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeEnglishSubjectFragment(): EnglishSubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeNewElectiveSubjectFragment(): NewElectiveSubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeNewEnglishSubjectFragment(): NewEnglishSubjectFragment

    @ContributesAndroidInjector
    abstract fun contributeSelectableElectiveSubjectsFragment(): SelectableElectiveSubjectsFragment

    @ContributesAndroidInjector
    abstract fun contributeSelectableEnglishSubjectsFragment(): SelectableEnglishSubjectsFragment
}