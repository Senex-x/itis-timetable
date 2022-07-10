package com.senex.timetable.presentation

import androidx.appcompat.app.AppCompatDelegate
import com.senex.timetable.di.DaggerAppComponent
import com.senex.timetable.presentation.common.prefs.ThemeSharedPrefsHandler
import com.senex.timetable.presentation.common.prefs.constants.AppTheme
import dagger.android.DaggerApplication
import javax.inject.Inject

class TimetableApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()

    @Inject
    lateinit var themePrefsHandler: ThemeSharedPrefsHandler

    override fun onCreate() {
        super.onCreate()

        when(themePrefsHandler.getSavedTheme()) {
            AppTheme.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            AppTheme.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}