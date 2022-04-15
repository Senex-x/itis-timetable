package com.senex.timetable.domain.model.subject

data class PrimaryElectiveSubject(
    val subjectId: Long,
    val dailyScheduleId: Long,
    val electiveSubjectId: Long,
)