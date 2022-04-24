package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import javax.inject.Inject

class HideEnglishSubject @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) {
    suspend operator fun invoke(englishSubjectId: Long) =
        englishSubjectRepository.hide(englishSubjectId)
}