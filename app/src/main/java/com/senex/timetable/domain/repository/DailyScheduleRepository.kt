package com.senex.timetable.domain.repository

import com.senex.timetable.data.model.schedule.DailySchedule
import com.senex.timetable.data.model.schedule.DailyScheduleEntity

interface DailyScheduleRepository: BaseRepository<DailyScheduleEntity> {
    suspend fun get(id: Long): DailySchedule?

    suspend fun getAll(): List<DailySchedule>

    suspend fun getAllByGroupIdAndDayNumber(
        groupId: Long,
        dayNumberInWeek: Int,
    ): List<DailySchedule>

    suspend fun deleteAll()
}