package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.repository.local.VariedSubjectRepository
import javax.inject.Inject

open class GetVariedSubject<T: VariedSubject> (
    private val variedSubjectRepository: VariedSubjectRepository<T>,
) {
    operator fun invoke(variedSubjectId: Long) =
        variedSubjectRepository.get(variedSubjectId)
}