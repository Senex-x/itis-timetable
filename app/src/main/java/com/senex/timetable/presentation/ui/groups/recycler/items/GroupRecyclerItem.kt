package com.senex.timetable.presentation.ui.groups.recycler.items

import com.senex.timetable.domain.entities.group.Group
import com.senex.timetable.common.recycler.TypedRecyclerItem

class GroupRecyclerItem(
    val group: Group,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.GROUP.value
}