package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.HiddenEnglishSubjectEntity
import com.senex.timetable.domain.model.subject.HiddenEnglishSubject

internal fun HiddenEnglishSubjectEntity.transform() = HiddenEnglishSubject(
    englishSubjectId,
)

internal fun HiddenEnglishSubject.transform() = HiddenEnglishSubjectEntity(
    englishSubjectId,
)