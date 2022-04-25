package com.senex.timetable.domain.model.subject

interface VariedSubject {
    val id: Long
    val dailyScheduleId: Long
    val primarySubjectId: Long?
    val isVisible: Boolean
}
