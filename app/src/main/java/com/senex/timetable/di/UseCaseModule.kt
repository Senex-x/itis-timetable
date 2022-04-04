package com.senex.timetable.di

import com.senex.timetable.domain.repository.GroupRepository
import com.senex.timetable.domain.repository.HiddenSubjectRepository
import com.senex.timetable.domain.repository.ScheduleRepository
import com.senex.timetable.domain.repository.SubjectRepository
import com.senex.timetable.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetScheduleByGroupIdSorted(
        scheduleRepository: ScheduleRepository,
    ) = GetScheduleByGroupIdSorted(scheduleRepository)

    @Singleton
    @Provides
    fun provideGetAllGroupsSorted(
        groupRepository: GroupRepository,
    ) = GetAllGroupsSorted(groupRepository)

    @Singleton
    @Provides
    fun provideGetAllSubjectsByGroupIdAndDay(
        subjectRepository: SubjectRepository,
    ) = GetAllSubjectsByGroupIdAndDay(subjectRepository)

    @Singleton
    @Provides
    fun provideDeleteHiddenSubjectById(
        hiddenSubjectRepository: HiddenSubjectRepository,
    ) = DeleteHiddenSubjectById(hiddenSubjectRepository)

    @Singleton
    @Provides
    fun provideGetHiddenSubjectById(
        hiddenSubjectRepository: HiddenSubjectRepository,
    ) = GetHiddenSubjectById(hiddenSubjectRepository)

    @Singleton
    @Provides
    fun provideInsertHiddenSubject(
        hiddenSubjectRepository: HiddenSubjectRepository,
    ) = InsertHiddenSubject(hiddenSubjectRepository)
}