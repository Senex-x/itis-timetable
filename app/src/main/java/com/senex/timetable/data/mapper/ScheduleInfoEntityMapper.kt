package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.schedule.ScheduleInfoEntity
import com.senex.timetable.domain.model.schedule.ScheduleInfo

internal fun ScheduleInfoEntity.transform() = ScheduleInfo(
    id,
    groupId,
)

internal fun ScheduleInfo.transform() = ScheduleInfoEntity(
    id,
    groupId,
)

