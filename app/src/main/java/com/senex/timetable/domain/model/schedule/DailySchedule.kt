package com.senex.timetable.domain.model.schedule

import com.senex.timetable.domain.model.subject.Subject

data class DailySchedule(
    val dailyScheduleInfo: DailyScheduleInfo,
    val subjects: List<Subject>,
)
