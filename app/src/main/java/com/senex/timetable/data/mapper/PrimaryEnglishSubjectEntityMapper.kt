package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.PrimaryEnglishSubjectEntity
import com.senex.timetable.domain.model.subject.PrimaryEnglishSubject

internal fun PrimaryEnglishSubjectEntity.transform() = PrimaryEnglishSubject(
    subjectId,
    dailyScheduleId,
    englishSubjectId,
)

internal fun PrimaryEnglishSubject.transform() = PrimaryEnglishSubjectEntity(
    subjectId,
    dailyScheduleId,
    englishSubjectId,
)