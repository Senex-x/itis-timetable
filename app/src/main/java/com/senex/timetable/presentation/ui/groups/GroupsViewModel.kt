package com.senex.timetable.presentation.ui.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.GetAllGroupsSorted
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import com.senex.timetable.presentation.ui.groups.recycler.toGroupsRecyclerItemList
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: SharedPreferencesHandler,
    getAllGroupsSorted: GetAllGroupsSorted,
) : ViewModel() {

    val groups = getAllGroupsSorted().map {
        it.toGroupsRecyclerItemList()
    }

    fun setPrimaryGroup(groupId: Long) =
        preferences.saveGroupId(groupId)
}