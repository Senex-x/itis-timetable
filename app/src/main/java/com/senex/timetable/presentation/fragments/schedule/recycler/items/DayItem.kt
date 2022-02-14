package com.senex.timetable.presentation.fragments.schedule.recycler.items

internal class DayItem(
    val name: String,
) : ScheduleListItem {
    override fun getViewType() = ScheduleListItemType.DAY.value
}