package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import javax.inject.Inject

class GetEnglishSubject @Inject constructor(
    englishSubjectRepository: EnglishSubjectRepository,
) : GetVariedSubject<EnglishSubject>(englishSubjectRepository)