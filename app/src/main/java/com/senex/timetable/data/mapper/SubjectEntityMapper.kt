package com.senex.timetable.data.mapper

import com.senex.timetable.data.entity.subject.SubjectEntity
import com.senex.timetable.domain.model.subject.Subject

internal fun SubjectEntity.transform() = Subject(
    id = id,
    dailyScheduleId = dailyScheduleId,
    electiveSubjectId = electiveSubjectId,
    englishSubjectId = englishSubjectId,
    isVisible = isVisible,
    isRemote = isRemote,
    periodicity = periodicity,
    indexInDay = indexInDay,
    startTime = startTime,
    endTime = endTime,
    name = name,
    room = room,
    type = type.transform(),
    kind = kind.transform(),
    teacherName = teacherName,
    teacherSurname = teacherSurname,
    teacherPatronymic = teacherPatronymic,
)

internal fun Subject.transform() = SubjectEntity(
    id = id,
    dailyScheduleId = dailyScheduleId,
    electiveSubjectId = electiveSubjectId,
    englishSubjectId = englishSubjectId,
    isVisible = isVisible,
    isRemote = isRemote,
    periodicity = periodicity,
    indexInDay = indexInDay,
    startTime = startTime,
    endTime = endTime,
    name = name,
    room = room,
    type = type.transform(),
    kind = kind.transform(),
    teacherName = teacherName,
    teacherSurname = teacherSurname,
    teacherPatronymic = teacherPatronymic,
)

private fun Subject.Kind.transform() =
    SubjectEntity.Kind.values().find { it.name == name }!!

private fun Subject.Type.transform() =
    SubjectEntity.Type.values().find { it.name == name }!!

private fun SubjectEntity.Kind.transform() =
    Subject.Kind.values().find { it.name == name }!!

private fun SubjectEntity.Type.transform() =
    Subject.Type.values().find { it.name == name }!!
