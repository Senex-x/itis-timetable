package com.senex.timetable.ui.fragments.schedule.recycler.items

import com.senex.timetable.model.entities.Subject

class SubjectScheduleItem(
    val item: Subject
) : ScheduleListItem {

    override fun getViewType(): Int {
        return ScheduleListItemType.Subject.value
    }
}