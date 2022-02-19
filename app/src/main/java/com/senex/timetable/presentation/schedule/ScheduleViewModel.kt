package com.senex.timetable.presentation.schedule

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.senex.timetable.data.repositories.ScheduleRepository
import com.senex.timetable.utils.SharedPreferencesHandler
import com.senex.timetable.utils.recycler.ScheduleRecyclerItemConverter

class ScheduleViewModel(application: Application) : AndroidViewModel(application) {
    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext
    private val scheduleRepository = ScheduleRepository()
    private val preferencesHandler = SharedPreferencesHandler(context)
    val schedule = ScheduleRecyclerItemConverter.convert(
        preferencesHandler.getSavedGroupId()?.let {
            scheduleRepository.getByGroupId(it)
        } ?: scheduleRepository.getFirst()
    )
}