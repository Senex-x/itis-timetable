package com.senex.timetable.presentation.schedule.recycler.items

import com.senex.timetable.utils.recycler.TypedRecyclerItem

internal class DayRecyclerItem(
    val name: String,
) : TypedRecyclerItem {
    override fun getViewType() = ScheduleRecyclerItemType.DAY.value
}