package com.senex.timetable.presentation.groups.recycler.items

import com.senex.timetable.data.models.Group
import com.senex.timetable.utils.recycler.TypedRecyclerItem

class GroupRecyclerItem(
    val group: Group,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.GROUP.value
}