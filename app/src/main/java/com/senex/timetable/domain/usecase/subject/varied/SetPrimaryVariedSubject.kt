package com.senex.timetable.domain.usecase.subject.varied

interface SetPrimaryVariedSubject {
    suspend operator fun invoke(
        variedSubjectId: Long,
        primarySubjectId: Long?,
    )
}