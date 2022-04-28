package com.senex.timetable.presentation.ui.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.group.GetAllGroupsSorted
import com.senex.timetable.domain.usecase.group.SyncAllGroups
import com.senex.timetable.domain.usecase.schedule.IsSchedulePresent
import com.senex.timetable.presentation.common.prefs.GroupSharedPrefsHandler
import com.senex.timetable.presentation.ui.groups.recycler.toGroupsRecyclerItemList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: GroupSharedPrefsHandler,
    syncAllGroups: SyncAllGroups,
    getAllGroupsSorted: GetAllGroupsSorted,
    private val isSchedulePresent: IsSchedulePresent,
) : ViewModel() {

    init {
        CoroutineScope(Dispatchers.Default).launch {
            syncAllGroups()
        }
    }

    val groupsRecyclerItems = getAllGroupsSorted().map {
        it.toGroupsRecyclerItemList(isSchedulePresent)
    }

    fun setPrimaryGroup(groupId: Long) =
        preferences.saveGroupId(groupId)
}