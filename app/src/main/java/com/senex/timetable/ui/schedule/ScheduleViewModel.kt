package com.senex.timetable.ui.schedule

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.map
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.common.log
import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.data.repositories.ScheduleRepository
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val scheduleRepository: ScheduleRepository,
    application: Application,
) : AndroidViewModel(application) {

    private val schedule = preferencesHandler.getSavedGroupId()?.let {
        scheduleRepository.getByGroupIdSorted(it)
    } ?: scheduleRepository.getFirst()

    fun getDailySubjects(
        dayOfWeek: DayOfWeek,
    ) = schedule.map { schedule ->
        log("Got update for daily subjects")

        if(schedule == null) {
            emptyList()
        } else {
            schedule.dailySchedules.find { dailySchedule ->
                dailySchedule.dailyScheduleEntity.numberInWeek == dayOfWeek.value
            }?.subjects ?: emptyList()
        }
    }
}