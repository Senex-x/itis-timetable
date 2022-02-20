package com.senex.timetable.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val application: Application,
) {
    @Provides
    fun provideAppContext() = application.applicationContext!!

    @Provides
    fun provideApplication() = application
}