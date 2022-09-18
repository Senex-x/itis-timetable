package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.Schedule
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetScheduleByGroupIdSorted @Inject constructor(
    private val getScheduleByGroupId: GetScheduleByGroupId,
    private val sortSchedule: SortSchedule,
) {
    operator fun invoke(groupId: Long) = getScheduleByGroupId(groupId).map {
        sortSchedule(it)
    }
}