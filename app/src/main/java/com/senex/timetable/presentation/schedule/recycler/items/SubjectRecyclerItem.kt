package com.senex.timetable.presentation.schedule.recycler.items

import com.senex.timetable.data.models.Subject
import com.senex.timetable.utils.recycler.TypedRecyclerItem

internal class SubjectRecyclerItem(
    val item: Subject
) : TypedRecyclerItem {
    override fun getViewType() = ScheduleRecyclerItemType.SUBJECT.value
}