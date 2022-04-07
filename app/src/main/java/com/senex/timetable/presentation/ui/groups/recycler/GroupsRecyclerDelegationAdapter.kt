package com.senex.timetable.presentation.ui.groups.recycler

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupsRecyclerItem

class GroupsRecyclerDelegationAdapter(
    onItemClickListener: ((Long) -> Unit)? = null,
) : AsyncListDifferDelegationAdapter<GroupsRecyclerItem>(
    GroupDiffCallback
) {
    init {
        delegatesManager
            .addDelegate(GroupsRecyclerItem.GroupItem.getAdapter(onItemClickListener))
            .addDelegate(GroupsRecyclerItem.CourseItem.getAdapter())
    }
}