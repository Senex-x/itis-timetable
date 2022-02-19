package com.senex.timetable.dagger

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val applicationContext: Context,
) {
    @Provides
    fun provideAppContext() = applicationContext
}