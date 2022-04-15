package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.repository.local.HiddenSubjectRepository
import javax.inject.Inject

class GetHiddenSubject @Inject constructor(
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) {
    operator fun invoke(id: Long) = hiddenSubjectRepository.get(id)
}