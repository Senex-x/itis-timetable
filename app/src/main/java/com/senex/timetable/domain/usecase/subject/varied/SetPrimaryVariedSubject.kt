package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.repository.local.VariedSubjectRepository

open class SetPrimaryVariedSubject<T: VariedSubject>(
    private val variedSubjectRepository: VariedSubjectRepository<T>,
) {
    suspend operator fun invoke(
        variedSubjectId: Long,
        primarySubjectId: Long?,
    ) = variedSubjectRepository.setPrimarySubjectId(
        variedSubjectId,
        primarySubjectId,
    )
}