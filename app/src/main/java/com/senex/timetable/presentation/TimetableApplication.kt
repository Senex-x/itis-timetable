package com.senex.timetable.presentation

import android.app.Application
import com.senex.timetable.data.database.MainDatabase

class TimetableApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        MainDatabase.init(applicationContext)
    }
}