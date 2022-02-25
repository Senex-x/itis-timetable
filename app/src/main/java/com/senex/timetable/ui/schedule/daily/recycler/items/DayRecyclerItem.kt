package com.senex.timetable.ui.schedule.daily.recycler.items

import com.senex.timetable.common.recycler.TypedRecyclerItem

internal class DayRecyclerItem(
    val name: String,
) : TypedRecyclerItem {
    override fun getViewType() = ScheduleRecyclerItemType.DAY.value
}