package com.senex.timetable.presentation

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.di.DaggerAppComponent
import com.senex.timetable.domain.util.log
import dagger.android.DaggerApplication
import javax.inject.Inject

class TimetableApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        debug()
    }

    private fun debug() {

    }
}