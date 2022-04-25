package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SaveAllVariedSubjects
import javax.inject.Inject

class SaveAllEnglishSubjects @Inject constructor(
    private val englishSubjectRepository: EnglishSubjectRepository,
) : SaveAllVariedSubjects<EnglishSubject> {
    override suspend operator fun invoke(variedSubjects: List<EnglishSubject>) =
        englishSubjectRepository.insertAll(*variedSubjects.toTypedArray())
}
