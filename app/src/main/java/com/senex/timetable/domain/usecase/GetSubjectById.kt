package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

class GetSubjectById @Inject constructor(
    private val subjectRepository: SubjectRepository
) {
    operator fun invoke(id: Long) = subjectRepository.get(id)
}