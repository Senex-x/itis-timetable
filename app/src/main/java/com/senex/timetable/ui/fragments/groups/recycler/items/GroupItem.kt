package com.senex.timetable.ui.fragments.groups.recycler.items

import com.senex.timetable.model.entities.Group

class GroupItem(
    val group: Group,
) : GroupListItem {
    override fun getViewType() = GroupListItemType.Group.value
}