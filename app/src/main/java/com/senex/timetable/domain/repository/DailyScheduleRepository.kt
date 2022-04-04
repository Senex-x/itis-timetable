package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo

interface DailyScheduleRepository: BaseRepository<DailyScheduleInfo> {
    suspend fun get(id: Long): DailySchedule?

    suspend fun getAll(): List<DailySchedule>

    suspend fun getAllByGroupIdAndDayNumber(
        groupId: Long,
        dayNumberInWeek: Int,
    ): List<DailySchedule>

    suspend fun deleteAll()
}