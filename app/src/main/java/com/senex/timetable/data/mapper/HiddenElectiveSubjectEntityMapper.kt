package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.HiddenElectiveSubjectEntity
import com.senex.timetable.domain.model.subject.HiddenElectiveSubject

internal fun HiddenElectiveSubjectEntity.transform() = HiddenElectiveSubject(
    electiveSubjectId,
)

internal fun HiddenElectiveSubject.transform() = HiddenElectiveSubjectEntity(
    electiveSubjectId,
)