package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import javax.inject.Inject

class GetElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) {
    operator fun invoke(electiveSubjectId: Long) =
        electiveSubjectRepository.get(electiveSubjectId)
}