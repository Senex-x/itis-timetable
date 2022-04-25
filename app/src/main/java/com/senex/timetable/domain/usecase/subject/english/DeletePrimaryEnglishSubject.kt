package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.usecase.subject.varied.DeletePrimaryVariedSubject
import javax.inject.Inject

class DeletePrimaryEnglishSubject @Inject constructor(
    private val setPrimaryEnglishSubject: SetPrimaryEnglishSubject,
) : DeletePrimaryVariedSubject {
    override suspend operator fun invoke(variedSubjectId: Long) =
        setPrimaryEnglishSubject(variedSubjectId, null)
}