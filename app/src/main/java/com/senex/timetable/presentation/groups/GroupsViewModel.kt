package com.senex.timetable.presentation.groups

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.models.Group
import com.senex.timetable.data.repositories.MainRepository
import com.senex.timetable.presentation.groups.recycler.items.GroupItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItemType

class GroupsViewModel : ViewModel() {
    val groups by lazy {
        MainRepository.getGroupListItems()
    }

    var onListChangeListener: ((List<GroupListItem>) -> Unit)? = null

    fun getGroup(id: Long): Group  {
        val groupListItem = groups.find { item ->
            item.getViewType() == GroupListItemType.GROUP.value
                    && (item as GroupItem).group.id == id
        } ?: throw IllegalArgumentException()

        return (groupListItem as GroupItem).group
    }

    fun setPrimaryGroup(groupId: Long) {
        // TODO: save state
    }

    private fun notifyListChangeListener() {
        onListChangeListener?.invoke(groups)
    }
}