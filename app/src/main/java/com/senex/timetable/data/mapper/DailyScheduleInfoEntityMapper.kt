package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo

internal fun DailyScheduleInfoEntity.transform() = DailyScheduleInfo(
    id,
    scheduleId,
    dayName,
    indexInWeek,
)

internal fun DailyScheduleInfo.transform() = DailyScheduleInfoEntity(
    id,
    scheduleId,
    dayName,
    indexInWeek,
)