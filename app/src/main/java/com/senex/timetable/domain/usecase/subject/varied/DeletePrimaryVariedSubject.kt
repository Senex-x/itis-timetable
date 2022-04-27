package com.senex.timetable.domain.usecase.subject.varied

open class DeletePrimaryVariedSubject(
    private val setPrimaryVariedSubject: SetPrimaryVariedSubject,
) {
    suspend operator fun invoke(variedSubjectId: Long) =
        setPrimaryVariedSubject(variedSubjectId, null)
}