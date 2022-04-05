package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo

interface DailyScheduleRepository: BaseRepository<DailyScheduleInfo, DailySchedule, Long> {
    suspend fun getAllByGroupIdAndDayIndex(
        groupId: Long,
        dayIndexInWeek: Int,
    ): List<DailySchedule>
}