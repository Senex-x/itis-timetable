package com.senex.timetable.presentation.fragments.groups.recycler.items

interface GroupListItem {
    fun getViewType(): Int
}

internal enum class GroupListItemType(val value: Int) {
    Course(1),
    Group(2),
}