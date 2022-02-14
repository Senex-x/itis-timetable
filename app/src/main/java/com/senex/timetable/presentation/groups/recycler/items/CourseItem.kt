package com.senex.timetable.presentation.groups.recycler.items

class CourseItem(
    val courseNumber: Int,
) : GroupListItem {
    override fun getViewType() = GroupListItemType.COURSE.value
}