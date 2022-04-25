package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import javax.inject.Inject

class ShowEnglishSubject @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) : ShowVariedSubject {
    override suspend operator fun invoke(variedSubjectId: Long) =
        englishSubjectRepository.show(variedSubjectId)
}