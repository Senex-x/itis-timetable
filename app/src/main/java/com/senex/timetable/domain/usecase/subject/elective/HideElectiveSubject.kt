package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import javax.inject.Inject

class HideElectiveSubject @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) : HideVariedSubject {
    override suspend operator fun invoke(variedSubjectId: Long) =
        electiveSubjectRepository.hide(variedSubjectId)
}