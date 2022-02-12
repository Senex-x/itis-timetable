package com.senex.timetable.ui.fragments.schedule.recycler

interface ScheduleListItem {
    fun getViewType(): Int
}

enum class ScheduleListItemType(val value: Int) {
    Day(1),
    Subject(2),
}