package com.senex.timetable.domain.entities.schedule

import com.senex.timetable.domain.entities.subject.Subject

data class DailySchedule(
    val dailyScheduleEntity: DailyScheduleEntity,
    val subjects: List<Subject>,
)
