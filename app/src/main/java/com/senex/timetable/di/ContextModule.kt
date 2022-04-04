package com.senex.timetable.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {
    @Singleton
    @Provides
    fun provideAppContext(application: Application) = application.applicationContext!!
}