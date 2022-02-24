package com.senex.timetable.ui.schedule.recycler.items

import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.common.recycler.TypedRecyclerItem

internal class SubjectRecyclerItem(
    val item: Subject
) : TypedRecyclerItem {
    override fun getViewType() = ScheduleRecyclerItemType.SUBJECT.value
}