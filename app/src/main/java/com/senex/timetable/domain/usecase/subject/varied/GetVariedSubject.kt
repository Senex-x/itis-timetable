package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.repository.local.VariedSubjectRepository
import javax.inject.Inject

open class GetVariedSubject<T> (
    private val variedSubjectRepository: VariedSubjectRepository<T>,
) {
    fun invoke(variedSubjectId: Long) =
        variedSubjectRepository.get(variedSubjectId)
}