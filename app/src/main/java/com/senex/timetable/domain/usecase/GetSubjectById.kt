package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.SubjectRepository

class GetSubjectById(
    private val subjectRepository: SubjectRepository
) {
    suspend operator fun invoke(id: Long) =
        subjectRepository.get(id)
}