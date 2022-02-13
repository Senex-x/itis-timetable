package com.senex.timetable.model.entities

data class DaySchedule(
    val numberInWeek: Int,
    val name: String,
    val subjects: List<Subject>,
)
