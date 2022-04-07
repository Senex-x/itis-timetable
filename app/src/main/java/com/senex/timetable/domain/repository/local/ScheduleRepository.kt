package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.model.schedule.ScheduleInfo
import com.senex.timetable.domain.repository.local.BaseRepository
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository : BaseRepository<ScheduleInfo, Schedule, Long> {
    fun getByGroupId(groupId: Long): Flow<Schedule?>
}