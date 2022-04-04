package com.senex.timetable.data.repository.remote

import androidx.lifecycle.liveData
import com.senex.timetable.data.api.ScheduleService
import com.senex.timetable.data.mapper.transform
import javax.inject.Inject

class ScheduleRemoteRepository @Inject constructor(
    private val scheduleService: ScheduleService,
) {
    fun getSchedule(groupId: Long) = liveData {
        emit(scheduleService.getSchedule(groupId)?.transform())
    }

    suspend fun getScheduleSuspending(groupId: Long) =
        scheduleService.getSchedule(groupId)?.transform()

    fun getSchedule(groupName: String) = liveData {
        emit(scheduleService.getSchedule(groupName)?.transform())
    }

    suspend fun getScheduleSuspending(groupName: String) =
        scheduleService.getSchedule(groupName)?.transform()
}