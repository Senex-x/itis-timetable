package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SetPrimaryVariedSubject
import javax.inject.Inject

class SetPrimaryEnglishSubject @Inject constructor(
    englishSubjectRepository: EnglishSubjectRepository,
) : SetPrimaryVariedSubject<EnglishSubject>(englishSubjectRepository)