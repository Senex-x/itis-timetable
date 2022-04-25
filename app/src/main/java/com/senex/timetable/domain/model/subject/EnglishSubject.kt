package com.senex.timetable.domain.model.subject

data class EnglishSubject(
    override val id: Long,
    override val dailyScheduleId: Long,
    override val primarySubjectId: Long?,
    override val isVisible: Boolean,
) : VariedSubject