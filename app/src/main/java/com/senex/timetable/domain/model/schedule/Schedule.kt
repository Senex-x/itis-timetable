package com.senex.timetable.domain.model.schedule

import com.senex.timetable.domain.model.group.Group

data class Schedule(
    val scheduleInfo: ScheduleInfo,
    val group: Group,
    val dailySchedules: List<DailySchedule>,
) {
    fun getDailySchedule(dayIndexInWeek: Int) = dailySchedules.find {
        it.dailyScheduleInfo.indexInWeek == dayIndexInWeek
    }
}