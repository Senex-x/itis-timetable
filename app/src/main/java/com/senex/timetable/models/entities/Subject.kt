package com.senex.timetable.models.entities

data class Subject(
    val startTime: String,
    val endTime: String,
    val name: String,
    val room: String,
    val type: SubjectType,
    val isOnEvenWeeks: Boolean,
    val isOnOddWeeks: Boolean,
    val teacherName: String,
    val teacherSurname: String,
    val teacherPatronymic: String,
) {
    val isOnEveryWeek = isOnEvenWeeks && isOnOddWeeks
}

enum class SubjectType {
    Lecture,
    Seminar,
}


