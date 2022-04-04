package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.model.schedule.ScheduleInfo

interface ScheduleRepository : BaseRepository<ScheduleInfo> {
    suspend fun get(id: Long): Schedule?

    suspend fun getByGroupId(groupId: Long): Schedule?

    suspend fun getAll(): List<Schedule>

    suspend fun deleteAll()
}