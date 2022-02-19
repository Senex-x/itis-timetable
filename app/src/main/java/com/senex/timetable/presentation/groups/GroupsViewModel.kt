package com.senex.timetable.presentation.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.utils.recycler.GroupListConverter

class GroupsViewModel : ViewModel() {
    val groups = GroupListConverter.convert(
        MainDatabase().groupDao().getAll()
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