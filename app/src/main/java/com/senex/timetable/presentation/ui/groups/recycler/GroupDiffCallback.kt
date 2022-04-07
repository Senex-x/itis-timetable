package com.senex.timetable.presentation.ui.groups.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.presentation.common.recycler.TypedRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItemType

object GroupDiffCallback : DiffUtil.ItemCallback<TypedRecyclerItem>() {
    override fun areItemsTheSame(
        oldItem: TypedRecyclerItem,
        newItem: TypedRecyclerItem,
    ) = when (oldItem) {
        is CourseRecyclerItem ->
            newItem is CourseRecyclerItem
                    && oldItem.courseNumber == newItem.courseNumber

        is GroupRecyclerItem ->
            newItem is GroupRecyclerItem
                    && oldItem.group.id == newItem.group.id

        else -> false
    }

    override fun areContentsTheSame(
        oldItem: TypedRecyclerItem,
        newItem: TypedRecyclerItem,
    ) = when (oldItem) {
        is CourseRecyclerItem ->
        newItem is CourseRecyclerItem
                && oldItem.courseNumber == newItem.courseNumber

        is GroupRecyclerItem ->
        newItem is GroupRecyclerItem
                && oldItem.group == newItem.group

        else -> false
    }
}