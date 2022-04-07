package com.senex.timetable.presentation.ui.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.usecase.GetAllGroupsSorted
import com.senex.timetable.presentation.common.SharedPreferencesHandler
import com.senex.timetable.presentation.common.recycler.GroupRecyclerItemConverter
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupsRecyclerItem
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: SharedPreferencesHandler,
    getAllGroupsSorted: GetAllGroupsSorted,
) : ViewModel() {
    // TODO: Refactor
    val groups = GroupRecyclerItemConverter.convert(
        getAllGroupsSorted().asLiveData(viewModelScope.coroutineContext)
    )

    // TODO: Refactor
    fun getGroup(id: Long): Group {
        val groupListItem = groups.value?.find {
            it is GroupsRecyclerItem.GroupItem && it.group.id == id
        } ?: throw IllegalStateException()

        return (groupListItem as GroupsRecyclerItem.GroupItem).group
    }

    fun setPrimaryGroup(groupId: Long) {
        preferences.saveGroupId(groupId)
    }
}