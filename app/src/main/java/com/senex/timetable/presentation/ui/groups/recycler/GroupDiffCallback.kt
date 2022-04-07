package com.senex.timetable.presentation.ui.groups.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupsRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupsRecyclerItem.CourseItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupsRecyclerItem.GroupItem

object GroupDiffCallback : DiffUtil.ItemCallback<GroupsRecyclerItem>() {
    override fun areItemsTheSame(
        oldItem: GroupsRecyclerItem,
        newItem: GroupsRecyclerItem,
    ) = when (oldItem) {
        is CourseItem ->
            newItem is CourseItem
                    && oldItem.courseNumber == newItem.courseNumber

        is GroupItem ->
            newItem is GroupItem
                    && oldItem.group.id == newItem.group.id
    }

    override fun areContentsTheSame(
        oldItem: GroupsRecyclerItem,
        newItem: GroupsRecyclerItem,
    ) = when (oldItem) {
        is CourseItem ->
        newItem is CourseItem
                && oldItem.courseNumber == newItem.courseNumber

        is GroupItem ->
        newItem is GroupItem
                && oldItem.group == newItem.group
    }
}