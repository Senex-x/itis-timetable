package com.senex.timetable.di

import com.senex.timetable.domain.repository.GroupRepository
import com.senex.timetable.domain.repository.ScheduleRepository
import com.senex.timetable.domain.usecase.GetAllGroupsSorted
import com.senex.timetable.domain.usecase.GetScheduleByGroupIdSorted
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
}