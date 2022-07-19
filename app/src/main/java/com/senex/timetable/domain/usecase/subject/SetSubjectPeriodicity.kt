package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

/**
 * @author v.n.polyakov
 */
class SetSubjectPeriodicity @Inject constructor(
    private val subjectRepository: SubjectRepository,
) {
    suspend operator fun invoke(periodicity: Subject.Periodicity, id: Long) =
        subjectRepository.setPeriodicity(periodicity, id)
}
