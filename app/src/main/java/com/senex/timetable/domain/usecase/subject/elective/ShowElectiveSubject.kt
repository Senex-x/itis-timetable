package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import javax.inject.Inject

class ShowElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) : ShowVariedSubject {
    override suspend operator fun invoke(variedSubjectId: Long) =
        electiveSubjectRepository.show(variedSubjectId)
}