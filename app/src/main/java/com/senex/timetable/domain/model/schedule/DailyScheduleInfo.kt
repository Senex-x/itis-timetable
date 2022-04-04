package com.senex.timetable.domain.model.schedule

data class DailyScheduleInfo(
    val id: Long,
    val scheduleId: Long,
    val dayName: String,
    val numberInWeek: Int,
)
