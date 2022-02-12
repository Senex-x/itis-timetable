package com.senex.timetable.ui.fragments.schedule.recycler.items

class DayScheduleItem(
    val name: String,
) : ScheduleListItem {

    override fun getViewType(): Int {
        return ScheduleListItemType.Day.value
    }
}