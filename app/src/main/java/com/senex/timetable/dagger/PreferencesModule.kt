package com.senex.timetable.dagger

import android.content.Context
import com.senex.timetable.utils.SharedPreferencesHandler
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {
    @Provides
    fun providePreferencesHandler(
        context: Context,
    ) = SharedPreferencesHandler(context)
}