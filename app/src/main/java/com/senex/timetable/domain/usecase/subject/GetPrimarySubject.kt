package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

class GetPrimarySubject @Inject constructor(
    private val subjectRepository: SubjectRepository,
) {
    operator fun invoke(primarySubjectId: Long) =
        subjectRepository.get(primarySubjectId)
}