package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

/**
 * @author v.n.polyakov
 */
class SetSubjectIsRemote @Inject constructor(
    private val subjectRepository: SubjectRepository,
) {
    suspend operator fun invoke(isRemote: Boolean, id: Long) =
        subjectRepository.setIsRemote(isRemote, id)
}
