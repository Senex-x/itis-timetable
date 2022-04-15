package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.elective.primary.GetPrimarySubjectByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.english.primary.GetPrimarySubjectByEnglishSubjectId
import com.senex.timetable.domain.usecase.schedule.GetScheduleByGroupIdSorted
import com.senex.timetable.domain.usecase.schedule.SyncScheduleByGroupId
import com.senex.timetable.domain.usecase.subject.elective.hidden.IsElectiveSubjectHidden
import com.senex.timetable.domain.usecase.subject.english.hidden.IsEnglishSubjectHidden
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
    private val getPrimarySubjectByElectiveSubjectId: GetPrimarySubjectByElectiveSubjectId,
    private val getPrimarySubjectByEnglishSubjectId: GetPrimarySubjectByEnglishSubjectId,
    private val isElectiveSubjectHidden: IsElectiveSubjectHidden,
    private val isEnglishSubjectHidden: IsEnglishSubjectHidden,
    syncScheduleByGroupId: SyncScheduleByGroupId,
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
            getPrimarySubjectByEnglishSubjectId,
            isElectiveSubjectHidden,
            isEnglishSubjectHidden,
        ) ?: emptyList()
    }

    private fun getScheduleFlow() = if (groupId == null) {
        flowOf(null)
    } else {
        getScheduleByGroupIdSorted(groupId)
    }
}