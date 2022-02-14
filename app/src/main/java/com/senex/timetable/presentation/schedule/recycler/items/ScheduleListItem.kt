package com.senex.timetable.presentation.schedule.recycler.items

interface ScheduleListItem {
    fun getViewType(): Int
}

internal enum class ScheduleListItemType(val value: Int) {
    DAY(1),
    SUBJECT(2),
}