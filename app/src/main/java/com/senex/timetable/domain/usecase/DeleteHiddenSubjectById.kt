package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.HiddenSubjectRepository

class DeleteHiddenSubjectById(
    private val hiddenSubjectRepository: HiddenSubjectRepository
) {
    suspend operator fun invoke(id: Long) =
        hiddenSubjectRepository.delete(id)
}