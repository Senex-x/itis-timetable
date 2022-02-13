package com.senex.timetable.model.entities

data class GroupSchedule(
    val groupName: String,
    val dailySchedules: List<DaySchedule>,
)

