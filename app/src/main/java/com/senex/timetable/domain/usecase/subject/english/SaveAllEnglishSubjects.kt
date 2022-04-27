package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SaveAllVariedSubjects
import javax.inject.Inject

class SaveAllEnglishSubjects @Inject constructor(
    englishSubjectRepository: EnglishSubjectRepository,
) : SaveAllVariedSubjects<EnglishSubject>(englishSubjectRepository)
