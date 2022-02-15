package com.senex.timetable.presentation.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.models.Group
import com.senex.timetable.presentation.groups.recycler.items.GroupItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItemType
import com.senex.timetable.utils.GroupListConverter

class GroupsViewModel : ViewModel() {
    val groups = GroupListConverter.convert(
        MainDatabase().groupDao().getAll()
    )

    // Maybe just retrieve it from db instead?
    fun getGroup(id: Long): Group  {
        val groupListItem = groups.value?.find { item ->
            item.getViewType() == GroupListItemType.GROUP.value
                    && (item as GroupItem).group.id == id
        } ?: throw IllegalStateException()

        return (groupListItem as GroupItem).group
    }

    fun setPrimaryGroup(groupId: Long) {
        // TODO: save state
    }
}