package com.senex.timetable.domain.entities.schedule

import com.senex.timetable.domain.entities.subject.Subject

data class DailySchedule(
    val dailyScheduleInfo: DailyScheduleInfo,
    val subjects: List<Subject>,
)
