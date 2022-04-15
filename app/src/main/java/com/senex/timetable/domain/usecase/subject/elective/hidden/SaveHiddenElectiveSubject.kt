package com.senex.timetable.domain.usecase.subject.elective.hidden

import com.senex.timetable.domain.model.subject.HiddenElectiveSubject
import com.senex.timetable.domain.repository.local.HiddenElectiveSubjectRepository
import javax.inject.Inject

class SaveHiddenElectiveSubject @Inject constructor(
    private val hiddenElectiveSubjectRepository: HiddenElectiveSubjectRepository,
) {
    suspend operator fun invoke(item: HiddenElectiveSubject) =
        hiddenElectiveSubjectRepository.insert(item)
}