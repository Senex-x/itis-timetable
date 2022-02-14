package com.senex.timetable.presentation.fragments.schedule.recycler.items

import com.senex.timetable.data.models.Subject

internal class SubjectItem(
    val item: Subject
) : ScheduleListItem {
    override fun getViewType() = ScheduleListItemType.Subject.value
}