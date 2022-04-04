package com.senex.timetable.domain.entities.schedule

data class DailyScheduleEntity(
    val id: Long,
    val scheduleId: Long,
    val dayName: String,
    val numberInWeek: Int,
)
