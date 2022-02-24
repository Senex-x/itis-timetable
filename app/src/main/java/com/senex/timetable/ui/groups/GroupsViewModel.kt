package com.senex.timetable.ui.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.data.repositories.GroupRepository
import com.senex.timetable.ui.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.ui.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.common.SharedPreferencesHandler
import com.senex.timetable.common.recycler.GroupRecyclerItemConverter
import javax.inject.Inject

class GroupsViewModel @Inject constructor(
    private val preferences: SharedPreferencesHandler,
    groupRepository: GroupRepository,
) : ViewModel() {
    val groups = GroupRecyclerItemConverter.convert(
        groupRepository.getAllSorted()
    )

    // Maybe just retrieve it from db instead?
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