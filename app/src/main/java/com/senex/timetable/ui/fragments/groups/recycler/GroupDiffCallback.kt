package com.senex.timetable.ui.fragments.groups.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.ui.fragments.groups.recycler.items.CourseItem
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupItem
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupListItem
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupListItemType

object GroupDiffCallback : DiffUtil.ItemCallback<GroupListItem>() {
    override fun areItemsTheSame(
        oldItem: GroupListItem,
        newItem: GroupListItem,
    ) = if (oldItem.getViewType() == GroupListItemType.Course.value
        && newItem.getViewType() == GroupListItemType.Course.value
    ) {
        (oldItem as CourseItem).courseNumber == (newItem as CourseItem).courseNumber
    } else if (oldItem.getViewType() == GroupListItemType.Group.value
        && newItem.getViewType() == GroupListItemType.Group.value
    ) {
        (oldItem as GroupItem).group.id == (newItem as GroupItem).group.id
    } else {
        false
    }

    override fun areContentsTheSame(
        oldItem: GroupListItem,
        newItem: GroupListItem,
    ) = if (oldItem.getViewType() == GroupListItemType.Course.value
        && newItem.getViewType() == GroupListItemType.Course.value
    ) {
        (oldItem as CourseItem).courseNumber == (newItem as CourseItem).courseNumber
    } else if (oldItem.getViewType() == GroupListItemType.Group.value
        && newItem.getViewType() == GroupListItemType.Group.value
    ) {
        (oldItem as GroupItem).group == (newItem as GroupItem).group
    } else {
        false
    }
}