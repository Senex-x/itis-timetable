package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.GetScheduleByGroupIdSorted
import com.senex.timetable.domain.usecase.SyncScheduleByGroupId
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getScheduleByGroupIdSorted: GetScheduleByGroupIdSorted,
    private val syncScheduleByGroupId: SyncScheduleByGroupId,
    preferencesHandler: SharedPreferencesHandler,
) : ViewModel() {
    private val groupId = preferencesHandler.getSavedGroupId()
    private val scheduleFlow = getScheduleFlow()

    private fun getScheduleFlow() = if (groupId == null) {
        flowOf(null)
    } else {
        getScheduleByGroupIdSorted(groupId)
    }

    init {
        groupId?.let {
            CoroutineScope(Dispatchers.Default).launch {
                syncScheduleByGroupId(it)
            }
        }
    }

    private val dailySubjects = Array(6) {
        getDailySubjects(dayIndexInWeek = it)
    }

    fun getDailySubjects(dayOfWeek: DayOfWeek) =
        dailySubjects[dayOfWeek.value - 1]

    private fun getDailySubjects(dayIndexInWeek: Int) = scheduleFlow.map {
        val dailySchedule = it?.getDailySchedule(dayIndexInWeek)
        //log("Schedule is: $it")
        dailySchedule?.subjects ?: emptyList()
    }
}