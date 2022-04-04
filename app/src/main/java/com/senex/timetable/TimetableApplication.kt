package com.senex.timetable

import com.senex.timetable.common.log
import com.senex.timetable.data.repositories.remote.ScheduleRemoteRepository
import com.senex.timetable.di.DaggerAppComponent
import dagger.android.DaggerApplication
import javax.inject.Inject

class TimetableApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        test()
    }

    private fun test() {

    }
}