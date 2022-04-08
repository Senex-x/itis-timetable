package com.senex.timetable.data.repository.remote

import com.senex.timetable.data.api.ScheduleService
import com.senex.timetable.data.entity.schedule.ScheduleEntity
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class ScheduleRemoteRepositoryImpl @Inject constructor(
    private val scheduleService: ScheduleService,
) : ScheduleRemoteRepository {

    override suspend fun getByGroupId(
        groupId: Long,
    ) = suspendCoroutine<ScheduleEntity?> {
        scheduleService.getSchedule(groupId).enqueue(continuationCallback(it))
    }?.transform()

    override suspend fun getByGroupName(
        groupName: String,
    ) = suspendCoroutine<ScheduleEntity?> {
        scheduleService.getSchedule(groupName).enqueue(continuationCallback(it))
    }?.transform()
}