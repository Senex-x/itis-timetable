package com.senex.timetable.presentation.ui.schedule.daily.recycler.items

import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.presentation.common.recycler.TypedRecyclerItem

internal class SubjectRecyclerItem(
    val item: Subject
) : TypedRecyclerItem {
    override fun getViewType() = ScheduleRecyclerItemType.SUBJECT.value
}