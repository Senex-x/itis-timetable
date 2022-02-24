package com.senex.timetable.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(
    private val application: Application,
) {
    @Singleton
    @Provides
    fun provideAppContext() = application.applicationContext!!

    @Singleton
    @Provides
    fun provideApplication() = application
}