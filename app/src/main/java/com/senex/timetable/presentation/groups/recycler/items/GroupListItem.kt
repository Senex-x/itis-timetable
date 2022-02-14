package com.senex.timetable.presentation.groups.recycler.items

interface GroupListItem {
    fun getViewType(): Int
}

internal enum class GroupListItemType(val value: Int) {
    COURSE(1),
    GROUP(2),
}