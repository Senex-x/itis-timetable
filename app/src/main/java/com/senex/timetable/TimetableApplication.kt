package com.senex.timetable

import android.app.Application
import android.content.Context
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.common.log
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.di.AppComponent
import com.senex.timetable.di.ContextModule
import com.senex.timetable.di.DaggerAppComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TimetableApplication : Application() {
    lateinit var daggerAppComponent: AppComponent

    @Inject
    lateinit var preferencesHandler: SharedPreferencesHandler

    @Inject
    lateinit var databse: AppDatabase

    override fun onCreate() {
        daggerAppComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
        daggerAppComponent.inject(this)

        debugDatabase()

        super.onCreate()
    }

    private fun debugDatabase() {
        CoroutineScope(Dispatchers.Default).launch {
            //databse.hiddenSubjectDao().getAll().toString().log()
        }
    }
}

val Context.daggerAppComponent: AppComponent
    get() = when (this) {
        is TimetableApplication -> daggerAppComponent
        else -> applicationContext.daggerAppComponent
    }