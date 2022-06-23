package com.senex.timetable.presentation.ui.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.group.GetGroup
import com.senex.timetable.domain.usecase.schedule.GetScheduleByGroupIdSorted
import com.senex.timetable.domain.usecase.schedule.SyncScheduleByGroupId
import com.senex.timetable.domain.util.log
import com.senex.timetable.presentation.common.prefs.DayNamesDisplayTypePrefs
import com.senex.timetable.presentation.common.prefs.GroupSharedPrefsHandler
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItem
import com.senex.timetable.presentation.ui.schedule.daily.recycler.toSubjectsRecyclerItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.*
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getGroup: GetGroup,
    private val getScheduleByGroupIdSorted: GetScheduleByGroupIdSorted,
    private val dayNamesDisplayTypePrefs: DayNamesDisplayTypePrefs,
    syncScheduleByGroupId: SyncScheduleByGroupId,
    preferencesHandler: GroupSharedPrefsHandler,
) : ViewModel() {

    val groupId = preferencesHandler.getSavedGroupId()
    // TODO: Inspect the difference between these two statements.
    //  Why is the above working well while the below fails to update value on runtime
    val dayNamesDisplayType
        get() = dayNamesDisplayTypePrefs.getDisplayType()

    init {
        groupId?.let {
            CoroutineScope(Dispatchers.Default).launch {
                syncScheduleByGroupId(it)
            }
        }
    }

    suspend fun getGroup() = groupId?.let {
        getGroup(it)
    }?.first()

    private val dailySubjectRecyclerItems = Array(6) {
        getSubjectsRecyclerItems(dayIndexInWeek = it)
    }

    fun getSubjectsRecyclerItems(dayOfWeek: DayOfWeek) =
        dailySubjectRecyclerItems[dayOfWeek.value - 1]

    private fun getSubjectsRecyclerItems(
        dayIndexInWeek: Int,
    ) = getScheduleFlow().map {
        it?.getDailySchedule(dayIndexInWeek)?.toSubjectsRecyclerItems()
            ?: emptyList()
    }

    private fun getScheduleFlow() = if (groupId == null)
        flowOf(null)
    else
        getScheduleByGroupIdSorted(groupId)

    suspend fun getLastSubjectEndTime(dayIndexInWeek: Int): Date {
        val timeString = when (
            val lastSubject =
                getSubjectsRecyclerItems(DayOfWeek.of(dayIndexInWeek + 1)).first().last()
        ) {
            is SubjectsRecyclerItem.OrdinaryItem -> lastSubject.subject.endTime
            is SubjectsRecyclerItem.BlockItem -> lastSubject.blockSubject.endTime
            is SubjectsRecyclerItem.ElectiveItem -> lastSubject.timePeriod.second
            is SubjectsRecyclerItem.EmptyItem -> lastSubject.emptySubject.endTime
            is SubjectsRecyclerItem.EnglishItem -> lastSubject.timePeriod.second
            is SubjectsRecyclerItem.PhysicalItem -> lastSubject.physicalSubject.endTime
        }
        return SimpleDateFormat("HH:mm", Locale.getDefault()).parse(timeString)!!
    }
}