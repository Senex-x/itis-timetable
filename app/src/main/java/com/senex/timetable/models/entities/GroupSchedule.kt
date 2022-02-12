package com.senex.timetable.models.entities

data class GroupSchedule(
    val groupName: String,
    val dailySchedules: List<DaySchedule>,
)

