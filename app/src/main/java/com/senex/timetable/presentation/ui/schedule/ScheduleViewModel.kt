package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.usecase.GetScheduleByGroupIdSorted
import com.senex.timetable.domain.usecase.SyncScheduleByGroupId
import com.senex.timetable.domain.util.log
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getScheduleByGroupIdSorted: GetScheduleByGroupIdSorted,
    private val syncScheduleByGroupId: SyncScheduleByGroupId,
    preferencesHandler: SharedPreferencesHandler,
) : ViewModel() {
    private val groupId = preferencesHandler.getSavedGroupId()

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

    private fun getDailySubjects(dayIndexInWeek: Int): Flow<List<Subject>> = flow {
        if (groupId == null) {
            emit(emptyList())
        } else {
            getScheduleByGroupIdSorted(groupId).collect {
                val dailySchedule = it?.getDailySchedule(dayIndexInWeek)
                //log("Schedule is: $it")
                emit(dailySchedule?.subjects ?: emptyList())
            }
        }
    }
}