package com.senex.timetable.ui.fragments.schedule.recycler.items

import com.senex.timetable.model.entities.Subject

internal class SubjectItem(
    val item: Subject
) : ScheduleListItem {
    override fun getViewType() = ScheduleListItemType.Subject.value
}