package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.repository.local.VariedSubjectRepository

open class HideVariedSubject<T> constructor(
    private val variedSubjectRepository: VariedSubjectRepository<T>,
) {
    suspend operator fun invoke(variedSubjectId: Long) =
        variedSubjectRepository.hide(variedSubjectId)
}