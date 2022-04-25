package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

class GetAllByElectiveSubjectId @Inject constructor(
    private val subjectRepository: SubjectRepository,
) : GetAllByVariedSubjectId {
    override operator fun invoke(variedSubjectId: Long) =
        subjectRepository.getAllByElectiveSubjectId(variedSubjectId)
}