package com.senex.timetable.domain.usecase

import com.senex.timetable.data.model.schedule.DailySchedule
import com.senex.timetable.data.model.schedule.Schedule
import com.senex.timetable.domain.repository.ScheduleRepository

class GetScheduleByGroupIdSorted(
    private val scheduleRepository: ScheduleRepository,
) {
    suspend operator fun invoke(groupId: Long) =
        sortSchedule(scheduleRepository.getByGroupId(groupId))

    private fun sortSchedule(
        source: Schedule?,
    ) = source?.run {
        val dailySchedulesSorted = dailySchedules.toMutableList()

        sortDailySchedules(dailySchedulesSorted)

        dailySchedulesSorted.sortWith(
            Comparator.comparingInt { it.dailyScheduleEntity.numberInWeek }
        )

        copy(
            schedule = schedule,
            group = group,
            dailySchedules = dailySchedulesSorted
        )
    }

    private fun sortDailySchedules(dailySchedulesSorted: MutableList<DailySchedule>) {
        for ((i, dailySchedule) in dailySchedulesSorted.withIndex()) {
            val subjectsSorted = sortSubjects(dailySchedule)
            val dailyScheduleSorted = dailySchedule.copy(
                dailyScheduleEntity = dailySchedule.dailyScheduleEntity,
                subjects = subjectsSorted
            )
            dailySchedulesSorted.add(i, dailyScheduleSorted)
        }
    }

    private fun sortSubjects(dailySchedule: DailySchedule) =
        dailySchedule.subjects.sortedWith { subject1, subject2 ->
            subject1.startTime.compareTo(subject2.startTime)
        }
}