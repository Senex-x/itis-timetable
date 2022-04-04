package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.schedule.DailyScheduleEntity
import com.senex.timetable.domain.entities.schedule.DailySchedule

fun DailyScheduleEntity.transform() = DailySchedule(
    dailyScheduleInfoEntity.transform(),
    subjectEntities.map { it.transform() },
)