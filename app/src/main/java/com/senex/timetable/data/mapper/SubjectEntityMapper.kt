package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.subject.SubjectEntity
import com.senex.timetable.domain.entities.subject.Subject

internal fun SubjectEntity.transform() = Subject(
    id,
    dailyScheduleId,
    numberInDay,
    startTime,
    endTime,
    name,
    room,
    type,
    isOnEvenWeeks,
    isOnOddWeeks,
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
    isOnEvenWeeks,
    isOnOddWeeks,
    teacherName,
    teacherSurname,
    teacherPatronymic,
)