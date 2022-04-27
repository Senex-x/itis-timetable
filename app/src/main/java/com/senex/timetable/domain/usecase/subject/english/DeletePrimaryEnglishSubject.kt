package com.senex.timetable.domain.usecase.subject.english

import com.senex.timetable.domain.usecase.subject.varied.DeletePrimaryVariedSubject
import javax.inject.Inject

class DeletePrimaryEnglishSubject @Inject constructor(
    setPrimaryEnglishSubject: SetPrimaryEnglishSubject,
) : DeletePrimaryVariedSubject(setPrimaryEnglishSubject)