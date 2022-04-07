package com.senex.timetable.data.repository.remote

import com.senex.timetable.data.api.ScheduleService
import com.senex.timetable.data.mapper.transform
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ScheduleRemoteRepositoryImpl @Inject constructor(
    private val scheduleService: ScheduleService,
) {
    fun getSchedule(groupId: Long) =
        scheduleService.getSchedule(groupId).map { it?.transform() }

    fun getSchedule(groupName: String) =
        scheduleService.getSchedule(groupName).map { it?.transform() }
}