package com.senex.timetable.presentation.ui.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import com.senex.timetable.presentation.common.recycler.GroupRecyclerItemConverter
import com.senex.timetable.domain.usecase.GetAllGroupsSorted
import com.senex.timetable.domain.util.log
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: SharedPreferencesHandler,
    getAllGroupsSorted: GetAllGroupsSorted,
) : ViewModel() {
    // TODO: Refactor
    val groups = GroupRecyclerItemConverter.convert(
        getAllGroupsSorted().asLiveData(viewModelScope.coroutineContext)
    )

    val groupsFlow = getAllGroupsSorted()

    // TODO: Retrieve directly from database
    fun getGroup(id: Long): Group {
        val groupListItem = groups.value?.find { item ->
            item.getViewType() == GroupRecyclerItemType.GROUP.value
                    && (item as GroupRecyclerItem).group.id == id
        } ?: throw IllegalStateException()

        return (groupListItem as GroupRecyclerItem).group
    }

    fun setPrimaryGroup(groupId: Long) {
        preferences.saveGroupId(groupId)
    }
}