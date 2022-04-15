package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.local.PrimaryElectiveSubjectRepository
import javax.inject.Inject

class GetPrimaryElectiveSubjectByElectiveSubjectId @Inject constructor(
    private val primaryElectiveSubjectRepository: PrimaryElectiveSubjectRepository,
) {
    operator fun invoke(electiveSubjectId: Long) =
        primaryElectiveSubjectRepository.getByElectiveSubjectId(electiveSubjectId)
}