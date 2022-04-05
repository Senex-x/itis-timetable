package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.senex.timetable.domain.usecase.GetScheduleByGroupIdSorted
import com.senex.timetable.domain.util.log
import com.senex.timetable.presentation.common.SharedPreferencesHandler
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

    private fun getDailySubjects(dayIndexInWeek: Int) = liveData {
        val groupId = preferencesHandler.getSavedGroupId()
        if (groupId == null) {
            emit(emptyList())
        } else {
            val schedule = getScheduleByGroupIdSorted(groupId)
            log(schedule.scheduleInfo.toString())
            log(schedule.dailySchedules.map { it.dailyScheduleInfo }.toString())
            val dailySchedule = schedule.getDailySchedule(dayIndexInWeek)
                ?: throw IllegalArgumentException()
            emit(dailySchedule.subjects)
        }
    }
}