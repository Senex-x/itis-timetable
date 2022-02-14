package com.senex.timetable.presentation.fragments.schedule.recycler.items

interface ScheduleListItem {
    fun getViewType(): Int
}

internal enum class ScheduleListItemType(val value: Int) {
    Day(1),
    Subject(2),
}