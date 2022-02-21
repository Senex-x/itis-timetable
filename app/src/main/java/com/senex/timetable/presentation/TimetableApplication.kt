package com.senex.timetable.presentation

import android.app.Application
import com.senex.timetable.dagger.AppComponent
import com.senex.timetable.dagger.ContextModule
import com.senex.timetable.dagger.DaggerAppComponent

class TimetableApplication : Application() {
    lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        daggerAppComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()

        super.onCreate()
    }
}