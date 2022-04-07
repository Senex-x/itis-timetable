package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.HiddenSubjectRepository
import javax.inject.Inject

class GetHiddenSubjectById @Inject constructor(
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) {
    operator fun invoke(id: Long) = hiddenSubjectRepository.get(id)
}