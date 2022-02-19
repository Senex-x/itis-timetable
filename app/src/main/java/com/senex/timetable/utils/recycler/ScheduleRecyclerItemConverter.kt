package com.senex.timetable.utils.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.senex.timetable.data.models.schedule.Schedule
import com.senex.timetable.presentation.schedule.recycler.items.DayRecyclerItem
import com.senex.timetable.presentation.schedule.recycler.items.SubjectRecyclerItem

object ScheduleRecyclerItemConverter {
    fun convert(source: LiveData<Schedule>): LiveData<List<TypedRecyclerItem>> {
        return Transformations.map(source) {
            if (it == null) return@map emptyList()

            val items = mutableListOf<TypedRecyclerItem>()

            for (dailySchedule in it.dailySchedules) {
                items.add(DayRecyclerItem(
                    dailySchedule.dailySchedule.name
                ))
                for (subject in dailySchedule.subjects) {
                    items.add(SubjectRecyclerItem(
                        subject
                    ))
                }
            }

            items
        }
    }
}