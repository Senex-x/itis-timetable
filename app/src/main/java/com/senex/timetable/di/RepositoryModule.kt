package com.senex.timetable.di

import com.senex.timetable.data.repository.local.*
import com.senex.timetable.domain.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindDailyScheduleRepository(
        dailyScheduleRepositoryImpl: DailyScheduleRepositoryImpl,
    ): DailyScheduleRepository

    @Singleton
    @Binds
    abstract fun bindsGroupRepository(
        groupRepositoryImpl: GroupRepositoryImpl,
    ): GroupRepository

    @Singleton
    @Binds
    abstract fun bindsHiddenSubjectRepository(
        hiddenSubjectRepositoryImpl: HiddenSubjectRepositoryImpl,
    ): HiddenSubjectRepository

    @Singleton
    @Binds
    abstract fun bindsScheduleRepository(
        scheduleRepositoryImpl: ScheduleRepositoryImpl,
    ): ScheduleRepository

    @Singleton
    @Binds
    abstract fun bindsSubjectRepository(
        subjectRepositoryImpl: SubjectRepositoryImpl,
    ): SubjectRepository
}