package com.senex.timetable.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.data.repositories.ScheduleRepository
import com.senex.timetable.data.repositories.SubjectRepository
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val scheduleRepository: ScheduleRepository,
    private val subjectRepository: SubjectRepository,
) : ViewModel() {

    private val schedule = scheduleRepository.getByGroupIdSorted(
        preferencesHandler.getSavedGroupId()
    )
/*
    fun getDailySubjects(
        dayOfWeek: DayOfWeek,
    ) = schedule.map { schedule ->
        if(schedule == null) {
            emptyList()
        } else {
            schedule.dailySchedules.find { dailySchedule ->
                dailySchedule.dailyScheduleEntity.numberInWeek == dayOfWeek.value
            }?.subjects ?: emptyList()
        }
    }*/

    fun getDailySubjects(dayOfWeek: DayOfWeek) = subjectRepository
        .getAllByGroupIdAndDayNumber(
            preferencesHandler.getSavedGroupId(),
            dayOfWeek.value,
        )
}