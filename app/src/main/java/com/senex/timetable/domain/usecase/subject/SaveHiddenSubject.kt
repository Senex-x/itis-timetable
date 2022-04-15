package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.model.subject.HiddenSubject
import com.senex.timetable.domain.repository.local.HiddenSubjectRepository
import javax.inject.Inject

class SaveHiddenSubject @Inject constructor(
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) {
    suspend operator fun invoke(item: HiddenSubject) =
        hiddenSubjectRepository.insert(item)
}