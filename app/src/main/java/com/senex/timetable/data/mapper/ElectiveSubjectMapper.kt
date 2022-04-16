package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.ElectiveSubjectEntity
import com.senex.timetable.domain.model.subject.ElectiveSubject

internal fun ElectiveSubjectEntity.transform() = ElectiveSubject(
    id,
    dailyScheduleId,
    primarySubjectId,
    isVisible,
)

internal fun ElectiveSubject.transform() = ElectiveSubjectEntity(
    id,
    dailyScheduleId,
    primarySubjectId,
    isVisible,
)