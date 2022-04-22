package com.senex.timetable.presentation

import com.senex.timetable.di.DaggerAppComponent
import dagger.android.DaggerApplication

class TimetableApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()
}