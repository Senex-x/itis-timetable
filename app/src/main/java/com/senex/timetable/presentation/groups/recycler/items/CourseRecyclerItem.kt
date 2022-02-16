package com.senex.timetable.presentation.groups.recycler.items

import com.senex.timetable.utils.recycler.TypedRecyclerItem

class CourseRecyclerItem(
    val courseNumber: Int,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.COURSE.value
}