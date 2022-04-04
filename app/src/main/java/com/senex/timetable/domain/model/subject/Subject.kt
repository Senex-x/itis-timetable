package com.senex.timetable.domain.model.subject

data class Subject(
    val id: Long,
    val dailyScheduleId: Long,
    val numberInDay: Int,
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


