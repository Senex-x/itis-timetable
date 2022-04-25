package com.senex.timetable.domain.usecase.subject.varied

interface HideVariedSubject {
    suspend operator fun invoke(variedSubjectId: Long)
}