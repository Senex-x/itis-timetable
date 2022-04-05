package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.model.schedule.ScheduleInfo

interface ScheduleRepository : BaseRepository<Schedule, Long> {
    suspend fun getByGroupId(groupId: Long): Schedule?
}