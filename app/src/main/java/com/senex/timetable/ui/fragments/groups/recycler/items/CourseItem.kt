package com.senex.timetable.ui.fragments.groups.recycler.items

class CourseItem(
    val courseNumber: Int,
) : GroupListItem {
    override fun getViewType() = GroupListItemType.Course.value
}