package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.GetPrimarySubjectByElectiveSubjectId
import com.senex.timetable.domain.usecase.GetPrimarySubjectByEnglishSubjectId
import com.senex.timetable.domain.usecase.GetScheduleByGroupIdSorted
import com.senex.timetable.domain.usecase.SyncScheduleByGroupId
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import com.senex.timetable.presentation.ui.schedule.daily.recycler.toSubjectsRecyclerItemList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getScheduleByGroupIdSorted: GetScheduleByGroupIdSorted,
    private val syncScheduleByGroupId: SyncScheduleByGroupId,
    private val getPrimarySubjectByElectiveSubjectId: GetPrimarySubjectByElectiveSubjectId,
    private val getPrimarySubjectByEnglishSubjectId: GetPrimarySubjectByEnglishSubjectId,
    preferencesHandler: SharedPreferencesHandler,
) : ViewModel() {
    private val groupId = preferencesHandler.getSavedGroupId()
    private val scheduleFlow = getScheduleFlow()

    init {
        groupId?.let {
            CoroutineScope(Dispatchers.Default).launch {
                syncScheduleByGroupId(it)
            }
        }
    }

    fun getDailySubjectRecyclerItems(dayOfWeek: DayOfWeek) =
        dailySubjectRecyclerItems[dayOfWeek.value - 1]

    private val dailySubjectRecyclerItems = Array(6) {
        getDailySubjectRecyclerItems(dayIndexInWeek = it)
    }

    private fun getDailySubjectRecyclerItems(
        dayIndexInWeek: Int,
    ) = scheduleFlow.map {
        it?.getDailySchedule(dayIndexInWeek)?.subjects?.toSubjectsRecyclerItemList(
            getPrimarySubjectByElectiveSubjectId,
            getPrimarySubjectByEnglishSubjectId
        ) ?: emptyList()
    }

    private fun getScheduleFlow() = if (groupId == null) {
        flowOf(null)
    } else {
        getScheduleByGroupIdSorted(groupId)
    }
}