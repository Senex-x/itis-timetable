package com.senex.timetable.domain.usecase.subject.english

import javax.inject.Inject

class DeletePrimaryEnglishSubject @Inject constructor(
    private val setPrimaryEnglishSubject: SetPrimaryEnglishSubject,
) {
    suspend operator fun invoke(englishSubjectId: Long) =
        setPrimaryEnglishSubject(englishSubjectId, null)
}