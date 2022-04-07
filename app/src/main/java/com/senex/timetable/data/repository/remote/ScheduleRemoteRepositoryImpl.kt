package com.senex.timetable.data.repository.remote

import com.senex.timetable.data.api.ScheduleService
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ScheduleRemoteRepositoryImpl @Inject constructor(
    private val scheduleService: ScheduleService,
) : ScheduleRemoteRepository {
    override fun getSchedule(groupId: Long) =
        scheduleService.getSchedule(groupId).map { it?.transform() }

    override fun getSchedule(groupName: String) =
        scheduleService.getSchedule(groupName).map { it?.transform() }
}