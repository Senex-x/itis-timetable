package com.senex.timetable.ui.groups.recycler.items

import com.senex.timetable.common.recycler.TypedRecyclerItem

class CourseRecyclerItem(
    val courseNumber: Int,
) : TypedRecyclerItem {
    override fun getViewType() = GroupRecyclerItemType.COURSE.value
}