package com.senex.timetable.presentation.schedule

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.senex.timetable.data.repositories.ScheduleRepository
import com.senex.timetable.utils.SharedPreferencesHandler
import com.senex.timetable.utils.recycler.ScheduleRecyclerItemConverter
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val scheduleRepository: ScheduleRepository,
    application: Application,
) : AndroidViewModel(application) {

    val schedule = ScheduleRecyclerItemConverter.convert(
        preferencesHandler.getSavedGroupId()?.let {
            scheduleRepository.getByGroupIdSorted(it)
        } ?: scheduleRepository.getFirst()
    )
}