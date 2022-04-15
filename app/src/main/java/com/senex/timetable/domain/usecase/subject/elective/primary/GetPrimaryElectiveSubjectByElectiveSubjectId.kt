package com.senex.timetable.domain.usecase.subject.elective.primary

import com.senex.timetable.domain.repository.local.PrimaryElectiveSubjectRepository
import javax.inject.Inject

class GetPrimaryElectiveSubjectByElectiveSubjectId @Inject constructor(
    private val primaryElectiveSubjectRepository: PrimaryElectiveSubjectRepository,
) {
    operator fun invoke(electiveSubjectId: Long) =
        primaryElectiveSubjectRepository.getByElectiveSubjectId(electiveSubjectId)
}