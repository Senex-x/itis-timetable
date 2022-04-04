package com.senex.timetable.ui.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.data.repositories.local.SubjectRepository
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val subjectRepository: SubjectRepository,
) : ViewModel() {
    private val dailySubjects = Array(7) {
        getDailySubjectsFromDatabase(DayOfWeek.of(it + 1))
    }

    fun getDailySubjects(dayOfWeek: DayOfWeek) =
        dailySubjects[dayOfWeek.value - 1]

    private fun getDailySubjectsFromDatabase(dayOfWeek: DayOfWeek) =
        preferencesHandler.getSavedGroupId()?.let {
            subjectRepository.getAll(
                it,
                dayOfWeek.value,
            )
        } ?: MutableLiveData()
}