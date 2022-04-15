package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.local.PrimaryEnglishSubjectRepository
import javax.inject.Inject

class GetPrimaryEnglishSubjectByEnglishSubjectId @Inject constructor(
    private val primaryEnglishSubjectRepository: PrimaryEnglishSubjectRepository
) {
    operator fun invoke(englishSubjectId: Long) =
        primaryEnglishSubjectRepository.getByEnglishSubjectId(englishSubjectId)
}