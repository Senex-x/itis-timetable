package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.HiddenSubjectRepository
import javax.inject.Inject

class DeleteHiddenSubjectById @Inject constructor(
    private val hiddenSubjectRepository: HiddenSubjectRepository
) {
    suspend operator fun invoke(id: Long) = hiddenSubjectRepository.deleteById(id)
}