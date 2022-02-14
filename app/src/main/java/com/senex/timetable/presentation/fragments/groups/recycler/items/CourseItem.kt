package com.senex.timetable.presentation.fragments.groups.recycler.items

class CourseItem(
    val courseNumber: Int,
) : GroupListItem {
    override fun getViewType() = GroupListItemType.COURSE.value
}