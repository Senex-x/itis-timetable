package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.schedule.DailyScheduleInfoEntity
import com.senex.timetable.domain.entities.schedule.DailyScheduleInfo

internal fun DailyScheduleInfoEntity.transform() = DailyScheduleInfo(
    id,
    scheduleId,
    dayName,
    numberInWeek,
)