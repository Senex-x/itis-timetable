package com.senex.timetable.data.models

data class GroupSchedule(
    val groupName: String,
    val dailySchedules: List<DaySchedule>,
)

