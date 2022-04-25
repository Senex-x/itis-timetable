package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SetPrimaryVariedSubject
import javax.inject.Inject

class SetPrimaryEnglishSubject @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) : SetPrimaryVariedSubject {
    override suspend operator fun invoke(
        variedSubjectId: Long,
        primarySubjectId: Long?,
    ) = englishSubjectRepository.setPrimarySubjectId(
        variedSubjectId,
        primarySubjectId,
    )
}