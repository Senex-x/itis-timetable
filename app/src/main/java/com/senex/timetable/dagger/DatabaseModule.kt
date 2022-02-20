package com.senex.timetable.dagger

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.MainDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun provideMainDatabase() : AppDatabase {
        // TODO: move initialisation here
        return MainDatabase()
    }
}