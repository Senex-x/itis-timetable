package com.senex.timetable.viewmodels

import androidx.lifecycle.ViewModel
import com.senex.timetable.model.entities.Group
import com.senex.timetable.model.repositories.MainRepository
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupItem
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupListItem
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupListItemType

class GroupsViewModel : ViewModel() {
    val groups by lazy {
        MainRepository.getGroupListItems()
    }

    var onListChangeListener: ((List<GroupListItem>) -> Unit)? = null

    fun getGroup(id: Long): Group  {
        val groupListItem = groups.find { item ->
            item.getViewType() == GroupListItemType.Group.value
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