package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.local.HiddenEnglishSubjectRepository
import javax.inject.Inject

class GetHiddenEnglishSubject @Inject constructor(
    private val hiddenEnglishSubjectRepository: HiddenEnglishSubjectRepository,
) {
    operator fun invoke(id: Long) = hiddenEnglishSubjectRepository.get(id)
}