package com.senex.timetable.domain.model.subject

data class EnglishSubject(
    val id: Long,
    val dailyScheduleId: Long,
    val primarySubjectId: Long?,
    val isVisible: Boolean,
)