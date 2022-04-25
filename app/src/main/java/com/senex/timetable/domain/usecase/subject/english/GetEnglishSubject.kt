package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import javax.inject.Inject

class GetEnglishSubject @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) : GetVariedSubject {
    override operator fun invoke(variedSubjectId: Long) =
        englishSubjectRepository.get(variedSubjectId)
}