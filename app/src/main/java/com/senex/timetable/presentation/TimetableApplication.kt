package com.senex.timetable.presentation

import android.app.Application
import com.senex.timetable.dagger.ApplicationComponent
import com.senex.timetable.dagger.ContextModule
import com.senex.timetable.dagger.DaggerApplicationComponent
import com.senex.timetable.data.database.MainDatabase

class TimetableApplication : Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this))
            .build()

        MainDatabase.init(applicationContext)
    }
}