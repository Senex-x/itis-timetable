package com.senex.timetable.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {
    @Provides
    fun provideSharedPreferences(
        context: Context,
    ):SharedPreferences = context.applicationContext.getSharedPreferences(
        PREF_FILE_NAME,
        Context.MODE_PRIVATE
    )

    companion object {
        private const val PREF_FILE_NAME =
            "com.senex.timetable.PREFERENCES"
    }
}