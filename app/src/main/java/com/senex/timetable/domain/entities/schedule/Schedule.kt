package com.senex.timetable.domain.entities.schedule

import com.senex.timetable.domain.entities.group.Group

data class Schedule(
    val scheduleInfo: ScheduleInfo,
    val group: Group,
    val dailySchedules: List<DailySchedule>,
)