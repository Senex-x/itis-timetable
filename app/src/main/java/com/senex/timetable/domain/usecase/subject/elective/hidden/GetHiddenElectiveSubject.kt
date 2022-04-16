package com.senex.timetable.domain.usecase.subject.elective.hidden

import com.senex.timetable.domain.repository.local.HiddenElectiveSubjectRepository
import javax.inject.Inject

class GetHiddenElectiveSubject @Inject constructor(
    private val hiddenElectiveSubjectRepository: HiddenElectiveSubjectRepository,
) {
    operator fun invoke(id: Long) = hiddenElectiveSubjectRepository.get(id)
}