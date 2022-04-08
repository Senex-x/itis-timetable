package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.PrimarySubjectEntity
import com.senex.timetable.domain.model.subject.PrimarySubject

internal fun PrimarySubjectEntity.transform() = PrimarySubject(
    subjectId,
)

internal fun PrimarySubject.transform() = PrimarySubjectEntity(
    subjectId,
)