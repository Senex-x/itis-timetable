package com.senex.timetable.dagger

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.repositories.GroupRepository
import com.senex.timetable.data.repositories.ScheduleRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideScheduleRepository(
        database: AppDatabase,
    ) = ScheduleRepository(database)

    @Provides
    fun provideGroupRepository(
        database: AppDatabase,
    ) = GroupRepository(database)
}