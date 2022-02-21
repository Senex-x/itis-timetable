package com.senex.timetable.presentation

import android.app.Application
import com.senex.timetable.dagger.AppComponent
import com.senex.timetable.dagger.ContextModule
import com.senex.timetable.dagger.DaggerApplicationComponent
import com.senex.timetable.data.database.MainDatabase

class TimetableApplication : Application() {
    lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        daggerAppComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this))
            .build()

        MainDatabase.init(applicationContext)

        super.onCreate()
    }
}