package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.SubjectEntity
import com.senex.timetable.domain.model.subject.Subject

internal fun SubjectEntity.transform() = Subject(
    id,
    dailyScheduleId,
    electiveSubjectId,
    englishSubjectId,
    isVisible,
    periodicity,
    indexInDay,
    startTime,
    endTime,
    name,
    room,
    type.transform(),
    kind.transform(),
    teacherName,
    teacherSurname,
    teacherPatronymic,
)

internal fun Subject.transform() = SubjectEntity(
    id,
    dailyScheduleId,
    electiveSubjectId,
    englishSubjectId,
    isVisible,
    periodicity,
    indexInDay,
    startTime,
    endTime,
    name,
    room,
    type.transform(),
    kind.transform(),
    teacherName,
    teacherSurname,
    teacherPatronymic,
)

private fun Subject.Kind.transform() =
    SubjectEntity.Kind.values().find { it.name == name }!!

private fun Subject.Type.transform() =
    SubjectEntity.Type.values().find { it.name == name }!!

private fun SubjectEntity.Kind.transform() =
    Subject.Kind.values().find { it.name == name }!!

private fun SubjectEntity.Type.transform() =
    Subject.Type.values().find { it.name == name }!!
