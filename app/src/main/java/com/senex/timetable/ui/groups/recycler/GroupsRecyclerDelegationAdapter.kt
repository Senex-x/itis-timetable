package com.senex.timetable.ui.groups.recycler

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.senex.timetable.common.recycler.TypedRecyclerItem

class GroupsRecyclerDelegationAdapter(
    private val onItemClickListener: ((Long) -> Unit)? = null
) : AsyncListDifferDelegationAdapter<TypedRecyclerItem>(
    GroupDiffCallback
) {
    init {
        delegatesManager
            .addDelegate(GroupDelegate(onItemClickListener))
            .addDelegate(CourseDelegate())
    }
}