package com.senex.timetable.data.repository.remote

import androidx.lifecycle.liveData
import com.senex.timetable.data.api.ScheduleService
import javax.inject.Inject

class ScheduleRemoteRepository @Inject constructor(
    private val scheduleService: ScheduleService,
) {
    fun getSchedule(groupId: Long) = liveData {
        emit(scheduleService.getSchedule(groupId))
    }

    suspend fun getScheduleSuspending(groupId: Long) =
        scheduleService.getSchedule(groupId)

    fun getSchedule(groupName: String) = liveData {
        emit(scheduleService.getSchedule(groupName))
    }

    suspend fun getScheduleSuspending(groupName: String) =
        scheduleService.getSchedule(groupName)
}