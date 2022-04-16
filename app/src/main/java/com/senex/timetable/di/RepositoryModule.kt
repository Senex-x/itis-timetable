package com.senex.timetable.di

import com.senex.timetable.data.repository.local.*
import com.senex.timetable.data.repository.remote.GroupRemoteRepositoryImpl
import com.senex.timetable.data.repository.remote.ScheduleRemoteRepositoryImpl
import com.senex.timetable.domain.repository.local.*
import com.senex.timetable.domain.repository.remote.GroupRemoteRepository
import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
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
    abstract fun bindGroupRepository(
        groupRepositoryImpl: GroupRepositoryImpl,
    ): GroupRepository

    @Singleton
    @Binds
    abstract fun bindScheduleRepository(
        scheduleRepositoryImpl: ScheduleRepositoryImpl,
    ): ScheduleRepository

    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
        subjectRepositoryImpl: SubjectRepositoryImpl,
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindScheduleRemoteRepository(
        scheduleRemoteRepositoryImpl: ScheduleRemoteRepositoryImpl
    ): ScheduleRemoteRepository

    @Singleton
    @Binds
    abstract fun bindGroupRemoteRepository(
        groupRemoteRepositoryImpl: GroupRemoteRepositoryImpl,
    ): GroupRemoteRepository

    @Singleton
    @Binds
    abstract fun bindElectiveSubjectRepository(
        electiveSubjectRepositoryImpl: ElectiveSubjectRepositoryImpl,
    ): ElectiveSubjectRepository

    @Singleton
    @Binds
    abstract fun bindEnglishSubjectRepository(
        englishSubjectRepositoryImpl: EnglishSubjectRepositoryImpl,
    ): EnglishSubjectRepository

    @Singleton
    @Binds
    abstract fun bindPrimaryElectiveSubjectRepository(
        repository: PrimaryElectiveSubjectRepositoryImpl,
    ): PrimaryElectiveSubjectRepository

    @Singleton
    @Binds
    abstract fun bindPrimaryEnglishSubjectRepository(
        repository: PrimaryEnglishSubjectRepositoryImpl,
    ): PrimaryEnglishSubjectRepository

    @Singleton
    @Binds
    abstract fun bindHiddenElectiveSubjectRepository(
        repository: HiddenElectiveSubjectRepositoryImpl,
    ): HiddenElectiveSubjectRepository

    @Singleton
    @Binds
    abstract fun bindHiddenEnglishSubjectRepository(
        repository: HiddenEnglishSubjectRepositoryImpl,
    ): HiddenEnglishSubjectRepository
}