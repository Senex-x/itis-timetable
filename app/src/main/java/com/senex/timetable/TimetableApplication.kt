package com.senex.timetable

import android.content.Context
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.di.AppComponent
import com.senex.timetable.di.DaggerAppComponent
import dagger.android.DaggerApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TimetableApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()

    lateinit var daggerAppComponent: AppComponent

    @Inject
    lateinit var preferencesHandler: SharedPreferencesHandler

    @Inject
    lateinit var databse: AppDatabase

    override fun onCreate() {

        debugDatabase()

        super.onCreate()
    }

    private fun debugDatabase() {
        CoroutineScope(Dispatchers.Default).launch {
            //databse.hiddenSubjectDao().getAll().toString().log()
        }
    }
}