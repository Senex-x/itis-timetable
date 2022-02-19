package com.senex.timetable.presentation.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.data.repositories.GroupRepository
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.utils.recycler.GroupRecyclerItemConverter

class GroupsViewModel : ViewModel() {
    val groups = GroupRecyclerItemConverter.convert(
        GroupRepository().getAllSorted()
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
        // TODO: save state
    }
}