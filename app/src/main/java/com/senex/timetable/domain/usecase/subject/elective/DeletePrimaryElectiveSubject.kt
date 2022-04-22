package com.senex.timetable.domain.usecase.subject.elective

import javax.inject.Inject

class DeletePrimaryElectiveSubject @Inject constructor(
    private val setPrimaryElectiveSubject: SetPrimaryElectiveSubject,
) {
    suspend operator fun invoke(electiveSubjectId: Long) =
        setPrimaryElectiveSubject(electiveSubjectId, null)
}