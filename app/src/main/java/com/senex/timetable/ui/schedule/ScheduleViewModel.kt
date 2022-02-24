package com.senex.timetable.ui.schedule

import android.app.Application
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.senex.timetable.data.repositories.ScheduleRepository
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.common.log
import com.senex.timetable.common.recycler.ScheduleRecyclerItemConverter
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