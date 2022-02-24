package com.senex.timetable.ui.groups.recycler.items

import com.senex.timetable.data.models.group.Group
import com.senex.timetable.common.recycler.TypedRecyclerItem

class GroupRecyclerItem(
    val group: Group,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.GROUP.value
}