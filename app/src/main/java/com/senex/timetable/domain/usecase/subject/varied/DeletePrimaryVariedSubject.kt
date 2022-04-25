package com.senex.timetable.domain.usecase.subject.varied

interface DeletePrimaryVariedSubject {
    suspend operator fun invoke(variedSubjectId: Long)
}