package com.senex.timetable.data.models

data class DaySchedule(
    val numberInWeek: Int,
    val name: String,
    val subjects: List<Subject>,
)
