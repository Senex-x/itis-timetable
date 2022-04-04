package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.schedule.ScheduleInfoEntity
import com.senex.timetable.domain.entities.schedule.ScheduleInfo

internal fun ScheduleInfoEntity.transform() = ScheduleInfo(
    id,
    groupId,
)

internal fun ScheduleInfo.transform() = ScheduleInfoEntity(
    id,
    groupId,
)

