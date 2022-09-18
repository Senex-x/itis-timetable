package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.Schedule
import javax.inject.Inject

class SortSchedule @Inject constructor() {

    operator fun invoke(source: Schedule?) = source?.run {
        val dailySchedulesSortedInside = sortDailySchedulesInside(dailySchedules)

        dailySchedulesSortedInside.sortWith(
            Comparator.comparingInt { it.dailyScheduleInfo.indexInWeek }
        )

        copy(
            scheduleInfo = scheduleInfo,
            group = group,
            dailySchedules = dailySchedulesSortedInside
        )
    }

    private fun sortDailySchedulesInside(dailySchedules: List<DailySchedule>): MutableList<DailySchedule> {
        val dailySchedulesSorted = mutableListOf<DailySchedule>()

        for (dailySchedule in dailySchedules) {
            val subjectsSorted = sortSubjects(dailySchedule)
            val dailyScheduleSorted = dailySchedule.copy(
                dailyScheduleInfo = dailySchedule.dailyScheduleInfo,
                subjects = subjectsSorted
            )
            dailySchedulesSorted.add(dailyScheduleSorted)
        }

        return dailySchedulesSorted
    }

    private fun sortSubjects(dailySchedule: DailySchedule) =
        dailySchedule.subjects.sortedWith(
            Comparator.comparingInt { it.indexInDay }
        )
}