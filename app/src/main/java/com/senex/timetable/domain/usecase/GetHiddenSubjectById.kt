package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.HiddenSubjectRepository

class GetHiddenSubjectById(
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) {
    suspend operator fun invoke(id: Long) =
        hiddenSubjectRepository.get(id)
}