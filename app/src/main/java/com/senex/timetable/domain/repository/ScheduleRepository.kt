package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.model.schedule.ScheduleInfo
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository : BaseRepository<ScheduleInfo, Schedule, Long> {
    fun getByGroupId(groupId: Long): Flow<Schedule?>
}