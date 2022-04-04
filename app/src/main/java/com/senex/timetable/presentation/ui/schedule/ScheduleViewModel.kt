package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.senex.timetable.domain.usecase.GetAllSubjectsByGroupIdAndDay
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val getAllSubjectsByGroupIdAndDay: GetAllSubjectsByGroupIdAndDay,
) : ViewModel() {
    private val dailySubjects = Array(6) {
        getDailySubjectsFromDatabase(DayOfWeek.of(it + 1))
    }

    fun getDailySubjects(dayOfWeek: DayOfWeek) =
        dailySubjects[dayOfWeek.value - 1]

    private fun getDailySubjectsFromDatabase(dayOfWeek: DayOfWeek) =
        preferencesHandler.getSavedGroupId()?.let {
            liveData {
                emit(getAllSubjectsByGroupIdAndDay(it, dayOfWeek))
            }
        } ?: MutableLiveData()
}