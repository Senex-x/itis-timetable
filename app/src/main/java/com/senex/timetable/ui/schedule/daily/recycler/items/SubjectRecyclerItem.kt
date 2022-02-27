package com.senex.timetable.ui.schedule.daily.recycler.items

import com.senex.timetable.data.models.subject.Subject
import com.senex.timetable.common.recycler.TypedRecyclerItem

internal class SubjectRecyclerItem(
    val item: Subject
) : TypedRecyclerItem {
    override fun getViewType() = ScheduleRecyclerItemType.SUBJECT.value
}