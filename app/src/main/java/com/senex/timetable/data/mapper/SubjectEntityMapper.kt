package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.SubjectEntity
import com.senex.timetable.domain.model.subject.Subject

internal fun SubjectEntity.transform() = Subject(
    id,
    dailyScheduleId,
    numberInDay,
    startTime,
    endTime,
    name,
    room,
    type,
    kind,
    teacherName,
    teacherSurname,
    teacherPatronymic,
)

internal fun Subject.transform() = SubjectEntity(
    id,
    dailyScheduleId,
    numberInDay,
    startTime,
    endTime,
    name,
    room,
    type,
    kind,
    teacherName,
    teacherSurname,
    teacherPatronymic,
)