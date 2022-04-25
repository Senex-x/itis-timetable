package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import javax.inject.Inject

class HideEnglishSubject @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) : HideVariedSubject {
    override suspend operator fun invoke(variedSubjectId: Long) =
        englishSubjectRepository.hide(variedSubjectId)
}