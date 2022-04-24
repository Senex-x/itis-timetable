package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import javax.inject.Inject

class GetEnglishSubject @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) {
    operator fun invoke(englishSubjectId: Long) =
        englishSubjectRepository.get(englishSubjectId)
}