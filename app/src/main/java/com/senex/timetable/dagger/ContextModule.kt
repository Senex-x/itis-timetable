package com.senex.timetable.dagger

import android.app.Application
import android.content.Context
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