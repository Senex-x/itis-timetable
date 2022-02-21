package com.senex.timetable.presentation

import android.app.Application
import android.content.Context
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

val Context.daggerAppComponent: AppComponent
    get() = when (this) {
        is TimetableApplication -> daggerAppComponent
        else -> applicationContext.daggerAppComponent
    }