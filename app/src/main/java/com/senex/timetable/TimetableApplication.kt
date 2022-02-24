package com.senex.timetable

import android.app.Application
import android.content.Context
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.data.repositories.GroupRepository
import com.senex.timetable.di.AppComponent
import com.senex.timetable.di.ContextModule
import com.senex.timetable.di.DaggerAppComponent
import dagger.Lazy
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TimetableApplication : Application() {
    lateinit var daggerAppComponent: AppComponent
    @Inject
    lateinit var preferencesHandler: SharedPreferencesHandler
    @Inject
    lateinit var groupRepository: Lazy<GroupRepository>

    override fun onCreate() {
        daggerAppComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
        daggerAppComponent.inject(this)

       if(preferencesHandler.isGroupNotSaved) {
           runBlocking {
               preferencesHandler.saveGroupId(
                   groupRepository.get().getRandomId()
               )
           }
       }

        super.onCreate()
    }
}

val Context.daggerAppComponent: AppComponent
    get() = when (this) {
        is TimetableApplication -> daggerAppComponent
        else -> applicationContext.daggerAppComponent
    }