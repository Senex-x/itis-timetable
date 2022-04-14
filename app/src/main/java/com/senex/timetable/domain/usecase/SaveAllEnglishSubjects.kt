package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import javax.inject.Inject

class SaveAllEnglishSubjects @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) {
    suspend operator fun invoke(englishSubjects: List<EnglishSubject>) =
        englishSubjectRepository.insertAll(*englishSubjects.toTypedArray())
}
