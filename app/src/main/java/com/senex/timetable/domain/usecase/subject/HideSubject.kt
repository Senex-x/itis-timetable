package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

class HideSubject @Inject constructor(
    private val subjectRepository: SubjectRepository,
) {
    suspend operator fun invoke(id: Long) = subjectRepository.hide(id)
}