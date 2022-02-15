package com.senex.timetable.data.models

data class GroupSchedule(
    val id: Long,
    val groupName: String,
    val dailySchedules: List<DaySchedule>,
)

