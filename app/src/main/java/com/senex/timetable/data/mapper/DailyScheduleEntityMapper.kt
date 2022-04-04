package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.schedule.DailyScheduleEntity
import com.senex.timetable.domain.model.schedule.DailySchedule

internal fun DailyScheduleEntity.transform() = DailySchedule(
    dailyScheduleInfoEntity.transform(),
    subjectEntities.map { it.transform() },
)

internal fun DailySchedule.transform() = DailyScheduleEntity(
    dailyScheduleInfo.transform(),
    subjects.map { it.transform() },
)