package com.senex.timetable.ui.fragments.schedule.recycler

class SubjectItem(
    val name: String,
) : ScheduleListItem {

    override fun getViewType(): Int {
        return ScheduleListItemType.Subject.value
    }
}