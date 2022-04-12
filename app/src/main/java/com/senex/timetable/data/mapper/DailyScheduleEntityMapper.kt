package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.schedule.DailyScheduleEntity
import com.senex.timetable.domain.model.schedule.DailySchedule

internal fun DailyScheduleEntity.transform() = DailySchedule(
    dailyScheduleInfoEntity.transform(),
    electiveSubjectEntities.map { it.transform() },
    englishSubjectEntities.map { it.transform() },
    subjectEntities.map { it.transform() },
)

internal fun DailySchedule.transform() = DailyScheduleEntity(
    dailyScheduleInfo.transform(),
    electiveSubjects.map { it.transform() },
    englishSubjects.map { it.transform() },
    subjects.map { it.transform() },
)