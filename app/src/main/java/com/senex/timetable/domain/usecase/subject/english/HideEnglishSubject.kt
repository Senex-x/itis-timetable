package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import javax.inject.Inject

class HideEnglishSubject @Inject constructor(
    englishSubjectRepository: EnglishSubjectRepository,
) : HideVariedSubject<EnglishSubject>(englishSubjectRepository)