package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.HiddenSubjectEntity
import com.senex.timetable.domain.model.subject.HiddenSubject

internal fun HiddenSubjectEntity.transform() = HiddenSubject(
    subjectId,
)

internal fun HiddenSubject.transform() = HiddenSubjectEntity(
    subjectId,
)