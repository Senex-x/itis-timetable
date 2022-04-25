package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SetPrimaryVariedSubject
import javax.inject.Inject

class SetPrimaryElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) : SetPrimaryVariedSubject {
    override suspend operator fun invoke(
        variedSubjectId: Long,
        primarySubjectId: Long?,
    ) = electiveSubjectRepository.setPrimarySubjectId(
        variedSubjectId,
        primarySubjectId,
    )
}