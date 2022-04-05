package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.model.schedule.ScheduleInfo

interface ScheduleRepository : BaseRepository<ScheduleInfo, Schedule, Long> {
    suspend fun getByGroupId(groupId: Long): Schedule?
}