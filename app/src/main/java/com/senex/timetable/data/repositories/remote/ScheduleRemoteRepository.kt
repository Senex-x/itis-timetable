package com.senex.timetable.data.repositories.remote

import androidx.lifecycle.liveData
import com.senex.timetable.data.api.ScheduleService
import com.senex.timetable.data.models.schedule.Schedule
import javax.inject.Inject

class ScheduleRemoteRepository @Inject constructor(
    private val scheduleService: ScheduleService,
) {
    fun getSchedule(groupId: Long) = liveData<Schedule?> {
        scheduleService.getSchedule(groupId)
    }

    suspend fun getScheduleSuspending(groupId: Long) =
        scheduleService.getSchedule(groupId)

    fun getSchedule(groupName: String) = liveData<Schedule?> {
        scheduleService.getSchedule(groupName)
    }

    suspend fun getScheduleSuspending(groupName: String) =
        scheduleService.getSchedule(groupName)
}