package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import com.senex.timetable.data.repository.local.SubjectRepositoryImpl
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val preferencesHandler: SharedPreferencesHandler,
    private val subjectRepository: SubjectRepositoryImpl,
) : ViewModel() {
    private val dailySubjects = Array(6) {
        getDailySubjectsFromDatabase(DayOfWeek.of(it + 1))
    }

    fun getDailySubjects(dayOfWeek: DayOfWeek) =
        dailySubjects[dayOfWeek.value - 1]

    private fun getDailySubjectsFromDatabase(dayOfWeek: DayOfWeek) =
        preferencesHandler.getSavedGroupId()?.let {
            liveData {
                emit(subjectRepository.getAll(
                    it,
                    dayOfWeek.value,
                ))
            }
        } ?: MutableLiveData()
}