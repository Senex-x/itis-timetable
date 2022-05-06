package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import javax.inject.Inject

class ShowEnglishSubject @Inject constructor(
    englishSubjectRepository: EnglishSubjectRepository,
) : ShowVariedSubject<EnglishSubject>(englishSubjectRepository)