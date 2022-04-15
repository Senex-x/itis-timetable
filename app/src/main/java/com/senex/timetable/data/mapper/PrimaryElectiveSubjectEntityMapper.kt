package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.PrimaryElectiveSubjectEntity
import com.senex.timetable.domain.model.subject.PrimaryElectiveSubject

internal fun PrimaryElectiveSubjectEntity.transform() = PrimaryElectiveSubject(
    subjectId,
    dailyScheduleId,
    electiveSubjectId,
)

internal fun PrimaryElectiveSubject.transform() = PrimaryElectiveSubjectEntity(
    subjectId,
    dailyScheduleId,
    electiveSubjectId,
)