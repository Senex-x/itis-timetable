package com.senex.timetable.domain.repository

import com.senex.timetable.data.model.schedule.Schedule
import com.senex.timetable.data.model.schedule.ScheduleEntity

interface ScheduleRepository : BaseRepository<ScheduleEntity> {
    suspend fun get(id: Long): Schedule?

    suspend fun getByGroupId(groupId: Long): Schedule?

    suspend fun getAll(): List<Schedule>

    suspend fun deleteAll()
}