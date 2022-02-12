package com.senex.timetable.models.entities

data class DaySchedule(
    val numberInWeek: Int,
    val name: String,
    val subjects: List<Subject>,
)
