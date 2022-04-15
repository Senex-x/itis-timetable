package com.senex.timetable.domain.usecase.subject.elective.hidden

import com.senex.timetable.domain.repository.local.HiddenElectiveSubjectRepository
import com.senex.timetable.domain.repository.local.HiddenSubjectRepository
import javax.inject.Inject

class DeleteHiddenElectiveSubjectById @Inject constructor(
    private val hiddenElectiveSubjectRepository: HiddenElectiveSubjectRepository
) {
    suspend operator fun invoke(id: Long) =
        hiddenElectiveSubjectRepository.deleteById(id)
}