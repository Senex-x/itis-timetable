package com.senex.timetable.presentation.ui.groups.recycler.items

import com.senex.timetable.common.recycler.TypedRecyclerItem

class CourseRecyclerItem(
    val courseNumber: Int,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.COURSE.value
}