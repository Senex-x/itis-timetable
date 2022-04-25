package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.usecase.subject.varied.DeletePrimaryVariedSubject
import javax.inject.Inject

class DeletePrimaryElectiveSubject @Inject constructor(
    private val setPrimaryElectiveSubject: SetPrimaryElectiveSubject,
) : DeletePrimaryVariedSubject {
    override suspend operator fun invoke(variedSubjectId: Long) =
        setPrimaryElectiveSubject(variedSubjectId, null)
}