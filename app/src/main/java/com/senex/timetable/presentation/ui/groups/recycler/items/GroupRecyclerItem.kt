package com.senex.timetable.presentation.ui.groups.recycler.items

import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.presentation.common.recycler.TypedRecyclerItem

class GroupRecyclerItem(
    val group: Group,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.GROUP.value
}