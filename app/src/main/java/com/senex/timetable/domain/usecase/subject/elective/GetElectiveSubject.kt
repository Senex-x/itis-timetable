package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import javax.inject.Inject

class GetElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) : GetVariedSubject {
    override fun invoke(variedSubjectId: Long) =
        electiveSubjectRepository.get(variedSubjectId)
}
