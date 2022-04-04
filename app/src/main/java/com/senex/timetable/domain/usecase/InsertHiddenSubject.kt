package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.subject.HiddenSubject
import com.senex.timetable.domain.repository.HiddenSubjectRepository

class InsertHiddenSubject(
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) {
    suspend operator fun invoke(item: HiddenSubject) =
        hiddenSubjectRepository.insert(item)
}