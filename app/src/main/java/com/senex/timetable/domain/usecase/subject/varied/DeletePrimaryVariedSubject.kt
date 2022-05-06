package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.model.subject.VariedSubject

open class DeletePrimaryVariedSubject<T: VariedSubject>(
    private val setPrimaryVariedSubject: SetPrimaryVariedSubject<T>,
) {
    suspend operator fun invoke(variedSubjectId: Long) =
        setPrimaryVariedSubject(variedSubjectId, null)
}