package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.Schedule
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetScheduleByGroupIdSorted @Inject constructor(
    private val getScheduleByGroupId: GetScheduleByGroupId,
) {
    operator fun invoke(groupId: Long) = getScheduleByGroupId(groupId).map {
        sortSchedule(it)
            ?: throw IllegalArgumentException("Schedule for groupId: $groupId not found")
    }

    private fun sortSchedule(
        source: Schedule?,
    ) = source?.run {
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
        dailySchedule.subjects.sortedWith { subject1, subject2 ->
            subject1.startTime.compareTo(subject2.startTime)
        }
}