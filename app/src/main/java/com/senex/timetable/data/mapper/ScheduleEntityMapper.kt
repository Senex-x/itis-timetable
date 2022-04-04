package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.schedule.ScheduleEntity
import com.senex.timetable.domain.entities.schedule.Schedule

internal fun ScheduleEntity.transform() = Schedule(
    scheduleInfoEntity.transform(),
    groupEntity.transform(),
    dailyScheduleEntities.map { it.transform() },
)

internal fun Schedule.transform() = ScheduleEntity(
    scheduleInfo.transform(),
    group.transform(),
    dailySchedules.map { it.transform() },
)