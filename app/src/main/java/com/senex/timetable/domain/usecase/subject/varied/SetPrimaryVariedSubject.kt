package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.repository.local.VariedSubjectRepository

open class SetPrimaryVariedSubject<T>(
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