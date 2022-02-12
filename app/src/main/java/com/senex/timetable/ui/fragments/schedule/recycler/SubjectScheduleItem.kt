package com.senex.timetable.ui.fragments.schedule.recycler

class SubjectScheduleItem(
    val name: String,
) : ScheduleListItem {

    override fun getViewType(): Int {
        return ScheduleListItemType.Subject.value
    }
}