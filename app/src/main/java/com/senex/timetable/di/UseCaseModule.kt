package com.senex.timetable.di

import com.senex.timetable.domain.usecase.subject.elective.DeletePrimaryElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.HideElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.ShowElectiveSubject
import com.senex.timetable.domain.usecase.subject.english.DeletePrimaryEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.HideEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.ShowEnglishSubject
import com.senex.timetable.domain.usecase.subject.varied.DeletePrimaryVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class UseCaseModule {

    @Singleton
    @Binds
    @Named("HideElectiveSubject")
    abstract fun bindHideElectiveSubject(
        implementation: HideElectiveSubject
    ): HideVariedSubject

    @Singleton
    @Binds
    @Named("HideEnglishSubject")
    abstract fun bindHideEnglishSubject(
        implementation: HideEnglishSubject
    ): HideVariedSubject

    @Singleton
    @Binds
    @Named("ShowElectiveSubject")
    abstract fun bindShowElectiveSubject(
        implementation: ShowElectiveSubject
    ): ShowVariedSubject

    @Singleton
    @Binds
    @Named("ShowEnglishSubject")
    abstract fun bindShowEnglishSubject(
        implementation: ShowEnglishSubject
    ): ShowVariedSubject

    @Singleton
    @Binds
    @Named("DeletePrimaryElectiveSubject")
    abstract fun bindDeletePrimaryElectiveSubject(
        implementation: DeletePrimaryElectiveSubject
    ): DeletePrimaryVariedSubject

    @Singleton
    @Binds
    @Named("DeletePrimaryEnglishSubject")
    abstract fun bindDeletePrimaryEnglishSubject(
        implementation: DeletePrimaryEnglishSubject
    ): DeletePrimaryVariedSubject
}