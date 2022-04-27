package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.repository.local.VariedSubjectRepository

open class SaveAllVariedSubjects<T> (
    private val variedSubjectRepository: VariedSubjectRepository<T>,
) {
    protected suspend fun insertAll(variedSubjects: Array<T>) =
        variedSubjectRepository.insertAll(*variedSubjects)
}
