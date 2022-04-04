package com.senex.timetable.di

import com.senex.timetable.data.repository.local.GroupRepositoryImpl
import com.senex.timetable.data.repository.local.HiddenSubjectRepositoryImpl
import com.senex.timetable.data.repository.local.ScheduleRepositoryImpl
import com.senex.timetable.data.repository.local.SubjectRepositoryImpl
import com.senex.timetable.domain.repository.GroupRepository
import com.senex.timetable.domain.repository.HiddenSubjectRepository
import com.senex.timetable.domain.repository.ScheduleRepository
import com.senex.timetable.domain.repository.SubjectRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [UseCaseModule::class])
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsGroupRepository(
        groupRepositoryImpl: GroupRepositoryImpl
    ): GroupRepository

    @Singleton
    @Binds
    abstract fun bindsHiddenSubjectRepository(
        hiddenSubjectRepositoryImpl: HiddenSubjectRepositoryImpl
    ): HiddenSubjectRepository

    @Singleton
    @Binds
    abstract fun bindsScheduleRepository(
        scheduleRepositoryImpl: ScheduleRepositoryImpl
    ): ScheduleRepository

    @Singleton
    @Binds
    abstract fun bindsSubjectRepository(
        subjectRepositoryImpl: SubjectRepositoryImpl
    ): SubjectRepository
}