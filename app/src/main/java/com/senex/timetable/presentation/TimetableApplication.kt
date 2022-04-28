package com.senex.timetable.presentation

import androidx.appcompat.app.AppCompatDelegate
import com.senex.timetable.di.DaggerAppComponent
import com.senex.timetable.presentation.common.GroupSharedPrefsHandler
import com.senex.timetable.presentation.common.Theme
import com.senex.timetable.presentation.common.ThemeSharedPrefsHandler
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
            Theme.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Theme.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}