package com.senex.timetable.domain.repository.remote

import com.senex.timetable.domain.model.schedule.Schedule

interface ScheduleRemoteRepository {
    suspend fun getSchedule(groupId: Long): Schedule?

    suspend fun getSchedule(groupName: String): Schedule?
}