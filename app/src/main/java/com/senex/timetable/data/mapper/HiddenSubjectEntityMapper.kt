package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.subject.HiddenSubjectEntity
import com.senex.timetable.domain.entities.subject.HiddenSubject

internal fun HiddenSubjectEntity.transform() = HiddenSubject(
    subjectId,
)

internal fun HiddenSubject.transform() = HiddenSubjectEntity(
    subjectId,
)