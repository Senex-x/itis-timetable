package com.senex.timetable.di

import com.senex.timetable.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Singleton
    @Provides
    fun provideDailyScheduleDao(
        appDatabase: AppDatabase,
    ) = appDatabase.dailyScheduleDao()

    @Singleton
    @Provides
    fun provideScheduleDao(
        appDatabase: AppDatabase,
    ) = appDatabase.scheduleDao()

    @Singleton
    @Provides
    fun provideGroupDao(
        appDatabase: AppDatabase,
    ) = appDatabase.groupDao()

    @Singleton
    @Provides
    fun provideHiddenSubjectDao(
        appDatabase: AppDatabase,
    ) = appDatabase.hiddenSubjectDao()

    @Singleton
    @Provides
    fun provideDailySubjectDao(
        appDatabase: AppDatabase,
    ) = appDatabase.subjectDao()

    @Singleton
    @Provides
    fun provideElectiveSubjectDao(
        appDatabase: AppDatabase,
    ) = appDatabase.electiveSubjectDao()

    @Singleton
    @Provides
    fun provideEnglishSubjectDao(
        appDatabase: AppDatabase,
    ) = appDatabase.englishSubjectDao()

    @Singleton
    @Provides
    fun providePrimaryElectiveSubjectDao(
        appDatabase: AppDatabase,
    ) = appDatabase.primaryElectiveSubjectDao()

    @Singleton
    @Provides
    fun providePrimaryEnglishSubjectDao(
        appDatabase: AppDatabase,
    ) = appDatabase.primaryEnglishSubjectDao()
}