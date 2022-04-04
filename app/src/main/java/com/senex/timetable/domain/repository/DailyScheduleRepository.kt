package com.senex.timetable.domain.repository

import com.senex.timetable.domain.entities.schedule.DailySchedule
import com.senex.timetable.domain.entities.schedule.DailyScheduleEntity

interface DailyScheduleRepository: BaseRepository<DailyScheduleEntity> {
    suspend fun get(id: Long): DailySchedule?

    suspend fun getAll(): List<DailySchedule>

    suspend fun getAllByGroupIdAndDayNumber(
        groupId: Long,
        dayNumberInWeek: Int,
    ): List<DailySchedule>

    suspend fun deleteAll()
}