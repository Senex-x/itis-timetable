package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import javax.inject.Inject

class ShowElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) {
    suspend operator fun invoke(electiveSubjectId: Long) =
        electiveSubjectRepository.show(electiveSubjectId)
}