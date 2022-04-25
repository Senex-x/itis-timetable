package com.senex.timetable.domain.usecase.subject.varied

interface ShowVariedSubject {
    suspend operator fun invoke(variedSubjectId: Long)
}