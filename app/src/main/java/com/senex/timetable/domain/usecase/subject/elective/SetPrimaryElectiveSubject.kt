package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import javax.inject.Inject

class SetPrimaryElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) {
    suspend operator fun invoke(
        electiveSubjectId: Long,
        primarySubjectId: Long?,
    ) = electiveSubjectRepository.setPrimarySubjectId(
        electiveSubjectId,
        primarySubjectId,
    )
}