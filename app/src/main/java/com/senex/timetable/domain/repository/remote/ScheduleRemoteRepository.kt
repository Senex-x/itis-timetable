package com.senex.timetable.domain.repository.remote

import com.senex.timetable.domain.model.schedule.Schedule

interface ScheduleRemoteRepository {
    suspend fun getByGroupId(groupId: Long): Schedule?

    suspend fun getByGroupName(groupName: String): Schedule?
}