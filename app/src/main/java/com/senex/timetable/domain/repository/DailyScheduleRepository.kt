package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo
import kotlinx.coroutines.flow.Flow

interface DailyScheduleRepository: BaseRepository<DailyScheduleInfo, DailySchedule, Long> {
    fun getAllByGroupIdAndDayIndex(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<DailySchedule>>
}