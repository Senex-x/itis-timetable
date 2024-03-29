package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.EnglishSubjectEntity
import com.senex.timetable.domain.model.subject.EnglishSubject

internal fun EnglishSubjectEntity.transform() = EnglishSubject(
    id,
    dailyScheduleId,
    primarySubjectId,
    isVisible,
)

internal fun EnglishSubject.transform() = EnglishSubjectEntity(
    id,
    dailyScheduleId,
    primarySubjectId,
    isVisible,
)