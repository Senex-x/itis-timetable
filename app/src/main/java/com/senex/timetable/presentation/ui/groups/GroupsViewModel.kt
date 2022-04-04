package com.senex.timetable.presentation.ui.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.model.group.Group
import com.senex.timetable.data.repository.local.GroupRepositoryImpl
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.common.recycler.GroupRecyclerItemConverter
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: SharedPreferencesHandler,
    groupRepository: GroupRepositoryImpl,
) : ViewModel() {
    val groups = GroupRecyclerItemConverter.convert(
        groupRepository.getAllSorted()
    )

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