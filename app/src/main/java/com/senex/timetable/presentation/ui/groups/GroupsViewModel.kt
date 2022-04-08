package com.senex.timetable.presentation.ui.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.GetAllGroupsSorted
import com.senex.timetable.domain.usecase.SyncAllGroups
import com.senex.timetable.domain.util.log
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import com.senex.timetable.presentation.ui.groups.recycler.toGroupsRecyclerItemList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: SharedPreferencesHandler,
    syncAllGroups: SyncAllGroups,
    getAllGroupsSorted: GetAllGroupsSorted,
) : ViewModel() {

    init {
        CoroutineScope(Dispatchers.Default).launch {
            syncAllGroups()
        }
    }

    val groups = getAllGroupsSorted().map {
        it.toGroupsRecyclerItemList()
    }

    fun setPrimaryGroup(groupId: Long) =
        preferences.saveGroupId(groupId)
}