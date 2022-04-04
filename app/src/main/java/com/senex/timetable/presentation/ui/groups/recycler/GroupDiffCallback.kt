package com.senex.timetable.presentation.ui.groups.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.presentation.ui.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.common.recycler.TypedRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItem

object GroupDiffCallback : DiffUtil.ItemCallback<TypedRecyclerItem>() {
    override fun areItemsTheSame(
        oldItem: TypedRecyclerItem,
        newItem: TypedRecyclerItem,
    ) = if (oldItem.getViewType() == GroupRecyclerItemType.COURSE.value
        && newItem.getViewType() == GroupRecyclerItemType.COURSE.value
    ) {
        (oldItem as CourseRecyclerItem).courseNumber == (newItem as CourseRecyclerItem).courseNumber
    } else if (oldItem.getViewType() == GroupRecyclerItemType.GROUP.value
        && newItem.getViewType() == GroupRecyclerItemType.GROUP.value
    ) {
        (oldItem as GroupRecyclerItem).group.id == (newItem as GroupRecyclerItem).group.id
    } else {
        false
    }

    override fun areContentsTheSame(
        oldItem: TypedRecyclerItem,
        newItem: TypedRecyclerItem,
    ) = if (oldItem.getViewType() == GroupRecyclerItemType.COURSE.value
        && newItem.getViewType() == GroupRecyclerItemType.COURSE.value
    ) {
        (oldItem as CourseRecyclerItem).courseNumber == (newItem as CourseRecyclerItem).courseNumber
    } else if (oldItem.getViewType() == GroupRecyclerItemType.GROUP.value
        && newItem.getViewType() == GroupRecyclerItemType.GROUP.value
    ) {
        (oldItem as GroupRecyclerItem).group == (newItem as GroupRecyclerItem).group
    } else {
        false
    }
}