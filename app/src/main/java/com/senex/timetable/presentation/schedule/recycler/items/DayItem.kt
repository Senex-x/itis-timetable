package com.senex.timetable.presentation.schedule.recycler.items

internal class DayItem(
    val name: String,
) : ScheduleListItem {
    override fun getViewType() = ScheduleListItemType.DAY.value
}