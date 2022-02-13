package com.senex.timetable.ui.fragments.schedule.recycler.items

internal class DayItem(
    val name: String,
) : ScheduleListItem {
    override fun getViewType() = ScheduleListItemType.Day.value
}