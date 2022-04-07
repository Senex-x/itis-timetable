package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.GetScheduleByGroupIdSorted
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val getScheduleByGroupIdSorted: GetScheduleByGroupIdSorted,
) : ViewModel() {
    private val dailySubjects = Array(6) {
        getDailySubjects(dayIndexInWeek = it)
    }

    fun getDailySubjects(dayOfWeek: DayOfWeek) =
        dailySubjects[dayOfWeek.value - 1]

    private fun getDailySubjects(dayIndexInWeek: Int) = flow {
        val groupId = preferencesHandler.getSavedGroupId()
        if (groupId == null) {
            emit(emptyList())
        } else {
            getScheduleByGroupIdSorted(groupId).collect {
                val dailySchedule = it.getDailySchedule(dayIndexInWeek)
                    ?: throw IllegalArgumentException()
                emit(dailySchedule.subjects)
            }
        }
    }
}